package xyz.miyayu.inventorymanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xyz.miyayu.inventorymanager.repository.FakeInventoryRepository

class MainActivity : AppCompatActivity() {
    // 7)recyclerViewの変数を用意
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 8)recyclerView表示
        recyclerView = findViewById(R.id.rv) // idの取得
        recyclerView.adapter = RecyclerAdapter(customList = FakeInventoryRepository.getAllData()) // adapterのセット
        recyclerView.layoutManager = LinearLayoutManager(this) // 各アイテムを縦に並べてください（見せ方の指示）
    }
}
