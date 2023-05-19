package com.example.hiltnewsetup

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BaseApplication() : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}