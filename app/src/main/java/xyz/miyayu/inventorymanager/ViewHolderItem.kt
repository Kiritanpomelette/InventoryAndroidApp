package xyz.miyayu.inventorymanager

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ViewHolderItem(itemView:View) : RecyclerView.ViewHolder(itemView) {
    //3) View(xml)の方から、指定のidを見つけてくる
    val ivHolder: ImageView = itemView.findViewById(R.id.iv)
    val tvNameHolder: TextView = itemView.findViewById(R.id.tvname)
    val tvMessageHolder: TextView = itemView.findViewById(R.id.tvmessage)
    val btnDetails: Button = itemView.findViewById(R.id.btnDetails)

    //9)クリック処理
    private val recyclerAdapter = RecyclerAdapter(arrayOf())
    private val nameList = recyclerAdapter.nameList

    init {
        itemView.setOnClickListener {
            val position: Int = adapterPosition
            Toast.makeText(itemView.context, "${nameList[position]}さんです", Toast.LENGTH_SHORT).show()
        }
    }
}