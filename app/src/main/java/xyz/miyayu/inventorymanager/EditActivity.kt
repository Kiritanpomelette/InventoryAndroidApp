package xyz.miyayu.inventorymanager

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_layout)


        val tv : TextView = findViewById(R.id.textView)
        val id = intent.getIntExtra("name",0)
        tv.text = id.toString()


    }
}
