package com.example.football6.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize


@Keep
@Parcelize
data class ResponceWebView(
    val url:String
):Parcelable