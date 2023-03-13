package org.apps.submissionandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListFoodAdapter(private val listFood: ArrayList<Food>)
    : RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>(){

    interface OnClickItemCallback{
        fun onItemChecked(data: Food)
    }

    private lateinit var onClickItemCallback: OnClickItemCallback

    fun setOnItemClickCallback(onClickItemCallback: OnClickItemCallback){
        this.onClickItemCallback = onClickItemCallback
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvNama: TextView = itemView.findViewById(R.id.tv_item_nama)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_foods,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val food = listFood[position]
        holder.imgPhoto.setImageResource(food.photo)
        holder.tvNama.text = food.nama
        holder.tvDesc.text = food.desc

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_food", listFood[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount() = listFood.size

}