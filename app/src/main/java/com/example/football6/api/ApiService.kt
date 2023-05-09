package com.example.football6.api

import com.example.football6.model.ResponceWebView
import com.example.football6.model.player
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("6/penalty.json")
    suspend fun getPlayerPenalty():Response<player>

    @GET("6/freekick.json")
    suspend fun getPlayerFreeKick():Response<player>

    @GET("6/corners.json")
    suspend fun getPlayerCorners():Response<player>

    @FormUrlEncoded
    @POST("splash.php")
    suspend fun setPostParametersPhone(
        @Field("phone_name") phone_name:String,
        @Field("locale") locale:String,
        @Field("unique") unique:String
    ):Response<ResponceWebView>



}