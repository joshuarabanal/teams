package com.example.myteams

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color.WHITE
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.example.data.TeamEntity
import com.example.myteams.teamAdapter.TeamViewHolder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.InputStream
import java.net.URL


class  WordListAdapter internal constructor(
    context: Context,
    private val vm: TeamsVM
) : RecyclerView.Adapter<TeamViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<TeamEntity>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = inflater.inflate(R.layout.activity_main_recycler_item, parent, false)
        return TeamViewHolder(itemView, vm)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.setTeam( words[position]);

    }

    internal fun setTeams(words: List<TeamEntity>?) {
        if(words == null){ return; }
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = words.size
}