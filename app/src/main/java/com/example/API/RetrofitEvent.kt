package com.example.API

import com.google.gson.annotations.SerializedName

class RetrofitEvent {

    @SerializedName("strEvent")
    private var name: String? = null

    @SerializedName("strDate")
    private var date: String? = null

    @SerializedName("strSport")
    private var sport: String? = null

    @SerializedName("strFilename")
    private var fileName: String? = null

    fun RetrofitEvent(
        name: String?,
        date: String?,
        sport: String?,
        fileName: String?
    ) {
        this.name = name
        this.date = date
        this.sport = sport
        this.fileName = fileName
    }

}