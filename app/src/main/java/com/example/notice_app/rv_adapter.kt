package com.example.notice_app

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class rv_adapter (var dataList:ArrayList<Rv_Model>, var context:Context):RecyclerView.Adapter<rv_adapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            var view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = dataList[position]
            holder.noticeid.text = currentItem.notice
            holder.summaryid.text = currentItem.summary
        }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noticeid: TextView = view.findViewById(R.id.notice) // Replace with actual ID
        val summaryid: TextView = view.findViewById(R.id.summary) // Replace with actual ID

    }

    }
