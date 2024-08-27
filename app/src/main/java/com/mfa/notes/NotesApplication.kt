package com.mfa.notes

import android.app.Application
import android.net.ConnectivityManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotesApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        //ConnectivityManager
    }
}