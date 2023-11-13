package xyz.miyayu.inventorymanager.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import xyz.miyayu.inventorymanager.model.Product
import java.net.HttpURLConnection
import java.net.URL
import java.util.Date


interface InventoryRepository {
    fun getAllData(): List<Product>
    fun getProduct(id: String): Product
}

object InventoryRepositoryImpl : InventoryRepository {
    override fun getAllData(): List<Product> {
        return runBlocking(Dispatchers.IO) {//非同期通信をするためのおまじない（本当はよくないけど仮）
            try {
                //ここでURLを指定する
                val url = URL("https://n3.miyayu.xyz/InventoryServer-0.0.1-SNAPSHOT-plain/products")
                //接続する
                val connection = (url.openConnection() as HttpURLConnection).apply {
                    connect()
                }

                //接続先からデータを持ってくる
                val text = connection.inputStream.bufferedReader().readText()

                //データオブジェクトに変換する
                return@runBlocking Json {
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                    coerceInputValues = true
                }.decodeFromString(text)
            } catch (e: Exception) {
                throw e
            }
        }
    }

    override fun getProduct(id: String): Product {
        return runBlocking(Dispatchers.IO) {//非同期通信をするためのおまじない（本当はよくないけど仮）
            try {
                //ここでURLを指定する
                val url = URL("https://n3.miyayu.xyz/InventoryServer-0.0.1-SNAPSHOT-plain/products/selectID?id=${id}")
                //接続する
                val connection = (url.openConnection() as HttpURLConnection).apply {
                    connect()
                }

                //接続先からデータを持ってくる
                val text = connection.inputStream.bufferedReader().readText()

                //データオブジェクトに変換する
                return@runBlocking Json {
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                    coerceInputValues = true
                }.decodeFromString(text)
            } catch (e: Exception) {
                throw e
            }
        }
    }
}

//ボスがいなくても動くコード
object FakeInventoryRepository : InventoryRepository {
    private var fakeProducts = listOf(
        Product(id = 1, name = "大志", memo = "1000円（北海道）", date = "2023/02/20"),
        Product(id = 2, name = "みや", memo = "2000円（登場）", date = "2023/02/20"),
        Product(id = 3, name = "ボス", memo = "3000円（韓国）", date = "2023/02/20"),
        Product(id = 4, name = "シュート", memo = "4000円（北海道）", date = "2023/02/20")
    )


    override fun getAllData(): List<Product> {
        return fakeProducts
    }

    override fun getProduct(id: String): Product {
        TODO("Not yet implemented")
    }
}