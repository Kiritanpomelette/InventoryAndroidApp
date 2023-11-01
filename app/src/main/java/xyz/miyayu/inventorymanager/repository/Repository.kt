package xyz.miyayu.inventorymanager.repository

import android.widget.ArrayAdapter
import xyz.miyayu.inventorymanager.model.Product


interface InventoryRepository {
    fun getAllData(): List<Product>
}
//ボスがいなくても動くコード
object FakeInventoryRepository : InventoryRepository {
    private var fakeProducts = listOf(
        Product(id = 1, name = "大志", memo = "1000円（北海道）", now = 10, today = 100, week = 150, month = 200, data = 2019),
        Product(id = 2, name = "みや", memo = "2000円（登場）", now = 20, today = 100, week = 150, month = 2000, data = 2020),
        Product(id = 3, name = "ボス", memo = "3000円（韓国）", now = 30, today = 100, week = 150, month = 200, data = 2021),
        Product(id = 4, name = "シュート", memo = "4000円（北海道）", now = 40, today = 100, week = 150, month = 200, data = 2022)
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