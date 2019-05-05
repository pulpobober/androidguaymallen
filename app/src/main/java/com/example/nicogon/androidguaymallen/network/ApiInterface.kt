package com.example.nicogon.androidguaymallen.network

import com.example.nicogon.androidguaymallen.TVModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("tv/popular")
    fun getPopular(@Query("api_key") api_key: String): Call<TVModel>
}