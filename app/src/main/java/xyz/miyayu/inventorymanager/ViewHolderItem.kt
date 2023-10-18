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
    val btnDetails: Button = itemView.findViewById(R.id.btnDetails)
    val tvBrandNameHolder: TextView = itemView.findViewById(R.id.brandName)
    val tvDescriptionHolder: TextView = itemView.findViewById(R.id.description)
    val btnEdit: Button = itemView.findViewById(R.id.btnEdit)

    // 9)クリック処理
    private val recyclerAdapter = RecyclerAdapter(arrayOf())
    private val nameList = recyclerAdapter.nameList

    init {
        itemView.setOnClickListener {
            val position: Int = adapterPosition
            Toast.makeText(itemView.context, "${nameList[position]}さんです", Toast.LENGTH_SHORT).show()
        }
    }
}
