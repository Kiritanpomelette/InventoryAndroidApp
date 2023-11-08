package xyz.miyayu.inventorymanager

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xyz.miyayu.inventorymanager.repository.InventoryRepository
import xyz.miyayu.inventorymanager.repository.InventoryRepositoryImpl

class DetailsActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.details_layout)

            val tvname : TextView = findViewById(R.id.name)
            val tvnow : TextView = findViewById(R.id.now)
            val tvtoday : TextView = findViewById(R.id.today)
            val tvweek : TextView = findViewById(R.id.week)
            val tvmonth : TextView = findViewById(R.id.month)


            val id = intent.getIntExtra("id",0)
            if (id != null) {
                val product = InventoryRepositoryImpl.getProduct(id = id.toString())
                // 製品情報を設定する
                tvname.text = product.name
                tvnow.text = product.date
                tvtoday.text = product.date
                tvweek.text = product.date
                tvmonth.text = product.date
            } else {
                // idがnullの場合の処理をここに書く
                // エラーメッセージを表示するか、アクティビティを終了するなど
            }


        }
}
