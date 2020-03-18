package com.example.searchActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.API.RetrofitEvent
import com.example.API.TeamAPI
import com.example.myteams.R
import com.example.myteams.TeamsVM
import com.example.myteams.teamAdapter.TeamViewHolder

class Adapter  internal constructor(
    context: Context
) : RecyclerView.Adapter<ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private  var events :List<RetrofitEvent>? = null ;

    public fun setQuery(team:String){
        var api = TeamAPI();
         api.queryEventByTeamName(
            team,
            {evt ->this.events = evt}
        );
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_second, parent, false)
        return ViewHolder(itemView);
    }

    override fun getItemCount(): Int {
        if(events == null)return 0;
        else return this.events!!.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.event = (events!!.get(position));
    }
}