package com.example.data

import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.API.TeamAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamDatabaseCallback(
    private val scope: CoroutineScope
) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {//first initialization of the team database
        super.onCreate(db)
        Log.i("TAG", "create database");
        TeamDatabase.INSTANCE?.let { database ->
            scope.launch {
                var newDefault = TeamEntity(
                    ""+Int.MAX_VALUE,
                    "Your Favorite Teams Appear Here",
                    "Soccer",
                    "https://www.thesportsdb.com/images/media/team/stadium/qpuxrr1419371354.jpg",
                    null,
                    null,
                    null,
                    "click on the search bar to search for your favorite teams. Open Each team and click the star icon to add them to your favorites"
                );
                database.teamDao().insert(newDefault);
            }
        }

    }
    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        Log.i("TAG","Instantiate database");
        TeamDatabase.INSTANCE?.let { database ->
            scope.launch {
                updateDatabase(database.teamDao())

            }
        }
    }
    private fun updateDatabase(teamDao: TeamDAO) {
        Log.i("TAG","update database");
        var teams:List<TeamEntity>?  =teamDao.getTeams().value;
        if(teams == null){
           Log.i("TAG", "teams are null");
            return;
        }
        Log.i("TAG", "Database: $teams");
        for(team in teams){
            updateTeam(team);
        }
    }
    private fun updateTeam(team:TeamEntity){
        if(Integer.parseInt(team.id)<0){ return ; }
        GlobalScope.launch { // launch a new coroutine in background and continue
            var teammAPI = TeamAPI();

        }
    }

}