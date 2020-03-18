package com.example.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RetrofitTeamList {
    @Expose
    @SerializedName("teams")
    public var teams: List<RetrofitTeam>? = null;
}