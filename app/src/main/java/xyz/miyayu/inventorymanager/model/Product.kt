package xyz.miyayu.inventorymanager.model

import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Product(
    val name: String,
    val date: String = "2023/02/20",
    val memo: String = "",
    val id: Int
)
