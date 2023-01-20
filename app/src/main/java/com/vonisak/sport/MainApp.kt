package com.vonisak.sport

import android.app.Application
import com.onesignal.OneSignal
import com.vonisak.sport.di.AppComponent
import com.vonisak.sport.di.DaggerAppComponent

const val ONESIGNAL_APP_ID = "8110a634-1f24-4f31-9a51-dd8949f67091"

class MainApp: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}