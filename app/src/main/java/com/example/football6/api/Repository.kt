package com.example.football6.api

import com.example.football6.model.ResponceWebView
import com.example.football6.model.player
import retrofit2.Response

class Repository {

    suspend fun getPlayerPenalty(): Response<player> {
        return RetrofitInstance.api.getPlayerPenalty()
    }

    suspend fun getPlayerFreeKick(): Response<player> {
        return RetrofitInstance.api.getPlayerFreeKick()
    }

    suspend fun getPlayerCorners(): Response<player> {
        return RetrofitInstance.api.getPlayerCorners()
    }

    suspend fun setParametersPhone(phone_name:String,locale:String,unique:String):Response<ResponceWebView>{
        return RetrofitInstance.api.setPostParametersPhone(phone_name, locale, unique)
    }

}