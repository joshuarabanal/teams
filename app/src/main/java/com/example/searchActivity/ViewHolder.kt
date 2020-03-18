package com.example.searchActivity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.API.RetrofitEvent
import com.example.myteams.TeamsVM

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    public var event:RetrofitEvent? = null
        set(value) {
            field = value;

        }



}