package com.suraj.greenlightplanetandroidassignment.ui.employee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suraj.greenlightplanetandroidassignment.R
import com.suraj.greenlightplanetandroidassignment.data.model.Employee
import kotlinx.android.synthetic.main.list_item.view.*

class EmployeeAdapter(var context: Context, var employeeList: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = employeeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextView.text = employeeList[position].name
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTextView: TextView = itemView.itemText
    }
}