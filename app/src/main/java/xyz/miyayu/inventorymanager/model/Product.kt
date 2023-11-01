package xyz.miyayu.inventorymanager.model

data class Product(
    val name: String,
    val now: Int,
    val today: Int,
    val week: Int,
    val month: Int,
    val memo: String,
    val data: Int,
    val id : Int
)
