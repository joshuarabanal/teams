package com.example.myteams.teamAdapter

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color.WHITE
import android.net.Uri
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.example.SearchActivity
import com.example.data.TeamEntity
import com.example.myteams.R
import com.example.myteams.TeamsVM
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.InputStream
import java.net.URL


class TeamViewHolder(itemView: View, private val vm:TeamsVM) : RecyclerView.ViewHolder(itemView) {
    private lateinit var  team_: TeamEntity
    val teamName: TextView = itemView.findViewById(R.id.textView);
    val teamBanner: ImageView = itemView.findViewById(R.id.imageView);
    val button : Button = itemView.findViewById(R.id.button);
    val cardview: CardView = itemView.findViewById(R.id.card_view);
    val facebook:ImageView = itemView.findViewById(R.id.facebook);
    val twitter:ImageView = itemView.findViewById(R.id.twitter);
    val instagram:ImageView = itemView.findViewById(R.id.instagram);
    val moreInfoLayout:View = itemView.findViewById(R.id.details)
    val description:TextView = itemView.findViewById(R.id.longDescription)
    val favorite:CheckBox = itemView.findViewById(R.id.checkBox)
    val gameHisory:Button = itemView.findViewById(R.id.game_history);

    var expanded = false;

    init{
        button.setOnClickListener({view->moreButton(view)})

        facebook.setOnClickListener({view->openLink(view, team_.facebookUrl)})
        instagram.setOnClickListener({view->openLink(view, team_.instagramUrl)})
        twitter.setOnClickListener({view->openLink(view, team_.twitterUrl)})
        gameHisory.setOnClickListener{view->viewGameHistory(view)};
        favorite.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener{compoundButton, b -> favoriteChecked(b) })
    }

    private fun viewGameHistory(view:View){
        var i = Intent(view.context, SearchActivity::class.java);
        i.putExtra("teamName", team_.name);
    }

    fun setTeam(value: TeamEntity) {
        this.team_ = value;
        teamName.setText(value.name);
        if( value.bannerURL.length > 0){
            setImageURL(value.bannerURL);
        }
        description.setText(value.description)
        if(value.facebookUrl == null|| value.facebookUrl.length == 0){
            facebook.visibility = View.INVISIBLE;
        }else{ facebook.visibility = View.VISIBLE; }

        if(value.instagramUrl == null || value.instagramUrl.length == 0){
            instagram.visibility = View.INVISIBLE;
        }else{ instagram.visibility = View.VISIBLE; }

        if(value.twitterUrl == null|| value.twitterUrl.length == 0){
            twitter.visibility = View.INVISIBLE;
        }else{ twitter.visibility = View.VISIBLE; }

        if(value.isFavorite){
            favorite.isChecked = true;
        }
        else{
            favorite.isChecked = false;
        }

        moreInfoLayout.visibility = View.GONE;

    }
    private fun moreButton(view:View){
        if(expanded){
            expanded = false;
            TransitionManager.beginDelayedTransition(cardview);
            moreInfoLayout.setVisibility(View.GONE);
        }
        else{
            expanded = true;
            TransitionManager.beginDelayedTransition(cardview);
            moreInfoLayout.setVisibility(View.VISIBLE);
        }
    }

    private fun favoriteChecked(isChecked: Boolean){
        if(isChecked){
            team_.isFavorite = true;
            vm.insert(team_);
        }
        else{
            vm.delete(team_);
        }
    }
    private fun openLink(view:View, url:String?){
        if(url == null ||url.length == 0){
            return;
        }
        var urls = url
        if(url.indexOf("http")!=0){
            urls = "https://"+url
        }
        var i = Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(urls));
        view.context.startActivity(i);
    }
    private fun setImageURL(url:String)= GlobalScope.launch {
        var logo : Bitmap? = null;
        runBlocking {
            val instream: InputStream = URL(url).openStream()
            logo = BitmapFactory.decodeStream(instream)


        }
        MainScope().launch {
            teamBanner.setImageBitmap(logo);
            Palette.generateAsync(logo, object : Palette.PaletteAsyncListener {
                override fun onGenerated(palette: Palette?) {
                    cardview.setCardBackgroundColor(palette!!.getLightMutedColor(WHITE));
                }
            })

        }
    }

}
