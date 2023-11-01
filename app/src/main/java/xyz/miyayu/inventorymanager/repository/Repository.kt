package xyz.miyayu.inventorymanager.repository

import xyz.miyayu.inventorymanager.model.Product
import java.util.Date


interface InventoryRepository {
    fun getAllData(): List<Product>
}
//ボスがいなくても動くコード
object FakeInventoryRepository : InventoryRepository {
    private var fakeProducts = listOf(
        Product(id = 1, name = "大志", memo = "1000円（北海道）", now = 10, date = Date()),
        Product(id = 2, name = "みや", memo = "2000円（登場）", now = 20, date = Date()),
        Product(id = 3, name = "ボス", memo = "3000円（韓国）", now = 30, date = Date() ),
        Product(id = 4, name = "シュート", memo = "4000円（北海道）", now = 40, date = Date())
    )



    override fun getAllData(): List<Product> {
        return fakeProducts
    }
}
//ボスのサーバーで動かすコード
object InternetInventoryRepository: InventoryRepository {
    override fun getAllData(): List<Product> {
        TODO("Not yet implemented")
    }
}