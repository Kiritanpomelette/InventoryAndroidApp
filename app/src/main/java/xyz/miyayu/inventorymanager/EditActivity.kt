package xyz.miyayu.inventorymanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import xyz.miyayu.inventorymanager.repository.FakeTreasurerRepository
import xyz.miyayu.inventorymanager.repository.TreasurerRepository
import xyz.miyayu.inventorymanager.repository.TreasurerRepositoryImpl

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_layout)


        val tvname : TextView = findViewById(R.id.name)
        val tvnow : TextView = findViewById(R.id.now)
        val savebtn : ImageButton = findViewById(R.id.savebtn)
        val textField : TextInputEditText = findViewById(R.id.textInputEditText)
        val textfi = textField


        val id = intent.getStringExtra("name")
        val now = intent.getIntExtra("now",11)

        tvname.text = id.toString()
        tvnow.text = now.toString()

        savebtn.setOnClickListener {
            if (textfi.text.isNullOrEmpty() ){
                Toast.makeText(this,"入力してください",Toast.LENGTH_SHORT).show()
            }else{
                TreasurerRepositoryImpl.insertTreasurer(
                    productId = 1, managerId = 1, count = textField.text.toString().toInt()
                )

                val text = "保存されました"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this,text,duration)
                toast.show()
            }
        }
    }

}
