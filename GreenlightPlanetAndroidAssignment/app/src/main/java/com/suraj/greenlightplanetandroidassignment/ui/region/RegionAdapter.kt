package com.suraj.greenlightplanetandroidassignment.ui.region

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.Region
import kotlinx.android.synthetic.main.list_item.view.*

class RegionAdapter(
    var context: Context,
    var regionList: List<Region>,
    var itemClickListener: ((Region) -> Unit)?
) : RecyclerView.Adapter<RegionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = regionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextView.text = regionList[position].region
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTextView: TextView = itemView.itemText

        init {
            itemView.setOnClickListener { itemClickListener?.invoke(regionList[adapterPosition]) }
        }
    }
}
