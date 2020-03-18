package com.example.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RetrofitEvents {
    @Expose
    @SerializedName("event")
    public var teams: List<RetrofitEvent>? = null;
}