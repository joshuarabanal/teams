package com.example.myteams

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.data.TeamDatabase
import com.example.data.TeamEntity
import com.example.data.TeamRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class TeamsVM (application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: TeamRepository
    // LiveData gives us updated words when they change.
    val allWords: LiveData<List<TeamEntity>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val wordsDao = TeamDatabase.getDatabase(application, MainScope()).teamDao()
        repository = TeamRepository(wordsDao)
        allWords = repository.allMyTeams
    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(team: TeamEntity) = this.viewModelScope.launch {
        repository.insert(team)
    }

    fun delete(team: TeamEntity) = this.viewModelScope.launch {
        repository.delete(team)
    }
}