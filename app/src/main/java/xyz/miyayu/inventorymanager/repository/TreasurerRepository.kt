package xyz.miyayu.inventorymanager.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import xyz.miyayu.inventorymanager.model.Treasurer
import java.net.HttpURLConnection
import java.net.URL
import java.util.Date
import kotlin.random.Random


interface TreasurerRepository{
    fun getAllTreasurer(): List<Treasurer>
    fun insertTreasurer(productId: Int,managerId: Int,count: Int)
}

object TreasurerRepositoryImpl: TreasurerRepository {
    override fun getAllTreasurer(): List<Treasurer> {
        return emptyList()
    }

    override fun insertTreasurer(productId: Int, managerId: Int, count: Int) {
        return runBlocking(Dispatchers.IO) {//非同期通信をするためのおまじない（本当はよくないけど仮）
            try {
                val pattern = "productId=${productId}&managerId=${managerId}&count=${count}"
                //ここでURLを指定する
                val url = URL("https://n3.miyayu.xyz/InventoryServer-0.0.1-SNAPSHOT-plain/treasurer")
                //接続する
                val connection = (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    setRequestProperty("Content-Type","application/x-www-form-urlencoded")
                    outputStream.write(pattern.toByteArray(Charsets.UTF_8))
                    connect()
                }
                println(connection.inputStream.bufferedReader().readText());
            } catch (e: Exception) {
                throw e
            }
        }
    }

}
object FakeTreasurerRepository: TreasurerRepository {

    //ダミーデータを定義する
    private var fakeTreasureres = listOf<Treasurer>(
        Treasurer(id=1, productId = 1, managerId = 1,Date(),1)
    )
    override fun getAllTreasurer() : List<Treasurer>{
        return fakeTreasureres
    }

    override fun insertTreasurer(productId: Int, managerId: Int, count: Int) {
        val treasurer = Treasurer(
            id = Random.nextInt(),
            productId = productId,
            managerId = managerId,
            count = count,
            modifyDate = Date()
        )
        fakeTreasureres = fakeTreasureres + treasurer
    }

}