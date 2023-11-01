package xyz.miyayu.inventorymanager.repository

import xyz.miyayu.inventorymanager.model.Treasurer
import java.util.Date
import kotlin.random.Random


interface TreasurerRepository{
    fun getAllTreasurer(): List<Treasurer>
    fun insertTreasurer(productId: Int,managerId: Int,count: Int)
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