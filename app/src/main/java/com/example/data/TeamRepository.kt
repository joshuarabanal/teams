package com.example.data

import androidx.lifecycle.LiveData

class TeamRepository(private val teamDao: TeamDAO) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allMyTeams: LiveData<List<TeamEntity>> = teamDao.getTeams()

    suspend fun insert(word: TeamEntity) {
        teamDao.insert(word)
    }
    suspend fun delete(team:TeamEntity){
        teamDao.remove(team);
    }
}