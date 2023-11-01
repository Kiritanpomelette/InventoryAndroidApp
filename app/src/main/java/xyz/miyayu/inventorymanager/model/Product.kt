package xyz.miyayu.inventorymanager.model

import java.util.Date

data class Product(
    val name: String,
    val now: Int,
    val date: Date,
    val memo: String,
    val id: Int
)
