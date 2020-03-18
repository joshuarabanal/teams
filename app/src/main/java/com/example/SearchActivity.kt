package com.example

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.API.TeamAPI
import com.example.data.TeamEntity
import com.example.myteams.R
import com.example.myteams.WordListAdapter
import com.example.searchActivity.Adapter


class SearchActivity : AppCompatActivity() {
    private val list: MutableLiveData<List<TeamEntity>> by lazy {
        MutableLiveData<List<TeamEntity>>()
    }
    private lateinit var adapter: Adapter;
    private lateinit var searchView:SearchView;
    private val api = TeamAPI();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val recyclerView = findViewById<RecyclerView>(R.id.team_recycler);
        adapter = Adapter(this)
        adapter.setQuery(this.intent.getStringExtra("team"));
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)



    }





}
