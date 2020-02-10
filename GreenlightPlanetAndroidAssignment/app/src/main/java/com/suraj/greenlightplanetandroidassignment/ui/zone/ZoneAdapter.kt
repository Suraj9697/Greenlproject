package com.suraj.greenlightplanetandroidassignment.ui.zone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.Zone
import kotlinx.android.synthetic.main.list_item.view.*

class ZoneAdapter(
    var context: Context,
    var list: List<Zone>,
    var itemClickListener: ((Zone) -> Unit)?
) :
    RecyclerView.Adapter<ZoneAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextView.text = list[position].zone
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTextView: TextView = itemView.itemText

        init {
            itemView.setOnClickListener { itemClickListener?.invoke(list[adapterPosition]) }
        }
    }
}