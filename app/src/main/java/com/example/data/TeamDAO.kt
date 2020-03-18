package com.example.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TeamDAO {

    @Query("SELECT * from my_teams_table ORDER by strTeam")
    public fun getTeams(): LiveData<List<TeamEntity>>

    @Query("Select * from my_teams_table where id_team = :teamId" )
    public fun getTeam(teamId:String) :LiveData<TeamEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: TeamEntity)

    @Delete
    suspend fun remove(team :TeamEntity)
}