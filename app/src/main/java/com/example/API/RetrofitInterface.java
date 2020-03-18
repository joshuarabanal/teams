package com.example.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @see("https://square.github.io/retrofit/")
 */
public interface RetrofitInterface {
    //https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=Arsenal
    @GET("api/v1/json/1/searchteams.php")
    Call<RetrofitTeamList> QueryTeams(@Query("t")  String teamName);

    //https://www.thesportsdb.com/api/v1/json/1/searchevents.php?e=Arsenal_vs_Chelsea
    @GET("api/v1/json/1/searchevents.php")
    Call<RetrofitEvents> queryEvents(@Query("e") String teamName);
}
