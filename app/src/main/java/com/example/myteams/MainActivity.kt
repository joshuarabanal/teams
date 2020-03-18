package com.example.myteams

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.InvalidationTracker
import com.example.API.TeamAPI
import com.example.SearchActivity
import com.example.data.TeamEntity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener  {
    private lateinit var teamViewModel:TeamsVM;
    private lateinit var adapter: WordListAdapter;
    private val api = TeamAPI();
    private var searchView:SearchView? = null ;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        teamViewModel = ViewModelProvider(this).get(TeamsVM::class.java)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->floatingbuttonCLick(view) }

        //set up the recycler view that holds the items
        val recyclerView = findViewById<RecyclerView>(R.id.team_recycler);
        adapter = WordListAdapter(this, teamViewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        connectWithVM();
    }
    fun floatingbuttonCLick( v: View) {
        searchView!!.callOnClick();
    }
     fun connectWithVM() {

        teamViewModel.allWords.observe(this,
            Observer { teams ->
                // Update the cached copy of the words in the adapter.
                adapter.setTeams(teams);
                if(searchView != null){
                    searchView!!.setIconified(true)
                };
            }
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        searchView = menu?.findItem(R.id.search_Teams)?.actionView as SearchView;
        if(searchView !=null) {
            searchView!!.setOnQueryTextListener(this)
            searchView!!.setOnCloseListener { closeSearch() }
            searchView!!.setQueryHint("Search By Team Name");
        }
        return super.onCreateOptionsMenu(menu)
        return true
    }
    private fun closeSearch(): Boolean{
        adapter.setTeams(teamViewModel.allWords.value)
        return false;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query == null || query.length == 0){
            adapter.setTeams(teamViewModel.allWords.value);
            searchView!!.setIconified(true);
            return true;
        }
        var list = api.queryTeamByName(query!!,
            {list->setList(list)}
        );
        ;
        Log.i("TAG", "set teams: $list")
        return true;
    }
    private fun setList(list: List<TeamEntity>){
        adapter.setTeams(list);
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText == null){
            adapter.setTeams(teamViewModel.allWords.value);
            return true;
        }
       var li = api.queryTeamByName(newText, { list->setList(list) });
        return true;
    }
}
