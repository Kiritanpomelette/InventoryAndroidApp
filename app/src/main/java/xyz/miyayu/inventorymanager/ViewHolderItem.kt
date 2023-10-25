package xyz.miyayu.inventorymanager

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // 3) View(xml)の方から、指定のidを見つけてくる
    // val ivHolder: ImageView = itemView.findViewById(R.id.iv)
    val tvNameHolder: TextView = itemView.findViewById(R.id.Now)
    val tvMessageHolder: TextView = itemView.findViewById(R.id.Today)
    val tvBrandNameHolder: TextView = itemView.findViewById(R.id.brandName)
    val tvDescriptionHolder: TextView = itemView.findViewById(R.id.description)
    val btnEdit: Button = itemView.findViewById(R.id.btnEdit)
    val btnDatails : Button = itemView.findViewById(R.id.btnDetails)
}
