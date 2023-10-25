package xyz.miyayu.inventorymanager

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import xyz.miyayu.inventorymanager.repository.InventoryRepository

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_layout)


        val tvname : TextView = findViewById(R.id.name)
        val tvnow : TextView = findViewById(R.id.now)
        val tvtoday : TextView = findViewById(R.id.today)
        val tvweek : TextView = findViewById(R.id.week)
        val tvmonth : TextView = findViewById(R.id.month)
        val tvmemo : TextView = findViewById(R.id.memo)

        val id = intent.getStringExtra("name")
        val now = intent.getIntExtra("now",0)
        val today = intent.getIntExtra("today",0)
        val week = intent.getIntExtra("week",0)
        val month = intent.getIntExtra("month",0)
        val memo = intent.getStringExtra("memo")

        tvname.text = id.toString()
        tvnow.text = now.toString()
        tvtoday.text = today.toString()
        tvweek.text = week.toString()
        tvmonth.text = month.toString()
        tvmemo.text = memo.toString()

    }
}
