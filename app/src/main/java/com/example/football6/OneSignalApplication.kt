package com.example.football6

import android.app.Application
import com.onesignal.OneSignal

class OneSignalApplication:Application() {

    val ONESIGNAL_APP_ID = "6342667f-e4b7-4f85-bb1e-2158cb8458f8"

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }


}