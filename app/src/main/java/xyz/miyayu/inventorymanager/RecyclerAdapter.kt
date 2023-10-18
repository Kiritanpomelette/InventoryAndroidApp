package xyz.miyayu.inventorymanager

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val customList:Array<String>): RecyclerView.Adapter<ViewHolderItem>(){
    //5)　表示するデータを用意
    private val BrandnameList = listOf("りんご","みかん","ぶどう","もも","なし","いちご")
    val nameList = listOf("My Name0","My Name1","My Name2","My Name3","My Name4","My Name5")
    private val messageList = listOf("My Message0","My Message1","My Message2","My Message3","My Message4","My Message5")
    private val descriptionList = listOf("りんごです","みかんです","ぶどうです","ももです","なしです","いちごです")
    //private val imageList = listOf(R.drawable.img0,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5)
    private val btnDetails = Details_Activity()
    //4) ここで1行分のレイアウト(view)を作る
    // (「2」と「3」を紐付ける作業)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        //「2」のレイアウトを取得(インフレート)
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }
        //5) position番目のデータをレイアウト(xml)に表示させるようにセット
        override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
            holder.tvNameHolder.text = nameList[position]
            holder.tvMessageHolder.text = messageList[position]
            //holder.ivHolder.setImageResource(imageList[position])
            holder.tvDescriptionHolder.text = descriptionList[position]
            holder.tvBrandNameHolder.text = BrandnameList[position]
            holder.btnDetails.setOnClickListener {
                val intent = Intent(holder.btnDetails.context, Details_Activity::class.java)
                ContextCompat.startActivity(holder.btnDetails.context, intent, null)
            }
            holder.btnEdit.setOnClickListener {
                val intent = Intent(holder.btnEdit.context, EditActivity::class.java)
                ContextCompat.startActivity(holder.btnEdit.context, intent, null)
            }
        }
        //6) データが何件あるかを確認する
        override fun getItemCount(): Int {
            return nameList.size
        }
    }