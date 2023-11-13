package xyz.miyayu.inventorymanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import xyz.miyayu.inventorymanager.repository.FakeInventoryRepository
import xyz.miyayu.inventorymanager.repository.InventoryRepositoryImpl

class MainActivity : AppCompatActivity() {
    // 7)recyclerViewの変数を用意
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 8)recyclerView表示
        recyclerView = findViewById(R.id.rv) // idの取得
        recyclerView.adapter =
            RecyclerAdapter(customList = InventoryRepositoryImpl.getAllData()) // adapterのセット
        recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity) // 各アイテムを縦に並べてください（見せ方の指示）
    }
}
