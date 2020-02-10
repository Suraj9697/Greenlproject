package com.suraj.greenlightplanetandroidassignment.ui.area

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.Area
import kotlinx.android.synthetic.main.list_item.view.*

class AreaAdapter(
    var context: Context,
    var areaList: List<Area>,
    var itemClickListener: ((Area) -> Unit)?
) : RecyclerView.Adapter<AreaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = areaList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextView.text = areaList[position].area
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTextView: TextView = itemView.itemText

        init {
            itemView.setOnClickListener { itemClickListener?.invoke(areaList[adapterPosition]) }
        }
    }
}