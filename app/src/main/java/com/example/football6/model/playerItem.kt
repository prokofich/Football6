package com.example.football6.model

import androidx.annotation.Keep


@Keep
data class playerItem(
    val name:String,
    val club:String,
    val record:String,
    val image:String
)