package xyz.miyayu.inventorymanager.repository

import android.widget.ArrayAdapter
import xyz.miyayu.inventorymanager.model.Product


interface InventoryRepository {
    fun getAllData(): List<Product>
}

//ボスがいなくても動くコード
object FakeInventoryRepository : InventoryRepository {
    private var fakeProducts = listOf(
        Product(name = "大志", memo = "1000円（北海道）", now = 10, today = 100, week = 150, month = 200),
        Product(name = "みや", memo = "2000円（登場）", now = 20, today = 100, week = 150, month = 2000),
        Product(name = "ボス", memo = "3000円（韓国）", now = 30, today = 100, week = 150, month = 200),
        Product(name = "シュート", memo = "4000円（北海道）", now = 40, today = 100, week = 150, month = 200)
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