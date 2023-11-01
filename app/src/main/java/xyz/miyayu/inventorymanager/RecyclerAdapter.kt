package xyz.miyayu.inventorymanager

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import xyz.miyayu.inventorymanager.model.Product

class RecyclerAdapter(private val customList: List<Product>) :
    RecyclerView.Adapter<ViewHolderItem>() {


    // 4) ここで1行分のレイアウト(view)を作る
    // (「2」と「3」を紐付ける作業)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        // 「2」のレイアウトを取得(インフレート)
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    // 5) position番目のデータをレイアウト(xml)に表示させる        ようにセット
    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        val product = customList[position]

        holder.tvNameHolder.text = product.name

        holder.tvMessageHolder.text = product.now.toString()

        holder.tvDescriptionHolder.text = product.memo

        holder.tvBrandNameHolder.text = product.name

        holder.btnEdit.setOnClickListener {
            val intent = Intent(holder.btnEdit.context, EditActivity::class.java)
            intent.putExtra("name",customList[position].name)
            intent.putExtra("now",customList[position].now)
            intent.putExtra("id",customList[position].month)
            ContextCompat.startActivity(holder.btnEdit.context, intent, null)
        }
        holder.btnDatails.setOnClickListener {
            val intent = Intent(holder.btnDatails.context,DetailsActivity::class.java)
            intent.putExtra("name",customList[position].name)
            intent.putExtra("now",customList[position].now)
            intent.putExtra("today",customList[position].today)
            intent.putExtra("week",customList[position].week)
            intent.putExtra("month",customList[position].month)
            intent.putExtra("memo",customList[position].memo)
            ContextCompat.startActivity(holder.btnDatails.context,intent,null)
        }
    }

    // 6) データが何件あるかを確認する
    override fun getItemCount(): Int {
        return customList.size
    }
}
