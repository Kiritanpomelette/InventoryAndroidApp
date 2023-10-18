package xyz.miyayu.inventorymanager

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderItem(itemView:View) : RecyclerView.ViewHolder(itemView){
    //3) View(xml)の方から、指定のidを見つけてくる
    val ivHolder : ImageView = itemView.findViewById(R.id.iv)
    val tvNameHolder : TextView = itemView.findViewById(R.id.tvname)
    val tvMessageHolder : TextView = itemView.findViewById(R.id.tvmessage)
}