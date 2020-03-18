package com.example.API

import android.util.Log
import com.example.data.TeamEntity
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TeamAPI {
    private val service:RetrofitInterface;

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(RetrofitInterface::class.java)
    }
    public fun test():Int{
        var integer = -1;
        var job: Job? = null
        var i = runBlocking {
            job = GlobalScope.launch {
                integer = 0;
            }
        }
        return integer;

    }
    public fun queryEventByTeamName( team: String,
                                     callback: (result: List<RetrofitEvent>?) -> Unit
    ){

        var items = service.queryEvents(team);
        var response: Response<RetrofitEvents>? = null;
        runBlocking {
            response = items.execute()
            //first.await();
        }

        if(response!!.isSuccessful){
            var listRetro = response!!.body();
            //Log.i("TAG", "retroList:$listRetro");
            //return toEntity(listRetro);
            MainScope().launch {
                callback(listRetro?.teams)
            }
        }
        else{
            MainScope().launch {
                callback(ArrayList<RetrofitEvent>())
            }
        }
    }

    public fun queryTeamByName(
        name:String,
        callback: (result: List<TeamEntity>) -> Unit) = GlobalScope.launch { // launch a new coroutine in background and continue {

        var items = service.QueryTeams(name);
        var response: Response<RetrofitTeamList>? = null;
        runBlocking {
            response = items.execute()
            //first.await();
        }

        if(response!!.isSuccessful){
            var listRetro = response!!.body();
            //Log.i("TAG", "retroList:$listRetro");
            //return toEntity(listRetro);
            MainScope().launch {
                callback(toEntity(listRetro?.teams))
            }
        }
        else{
            MainScope().launch {
                callback(ArrayList<TeamEntity>())
            }
        }
    }
    private fun toEntity(input: List<RetrofitTeam>?):List<TeamEntity>{
        var retu = ArrayList<TeamEntity>();
        if(input == null){
            return retu;
        }
        for(retrofitTeam in input){
            retu.add(retrofitTeam.toEntity());
        }
        return retu;
    }
}