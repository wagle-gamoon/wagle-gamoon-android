package com.codelap.waglegamoon

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class GamoonApplication: Application() {

    companion object {
        private lateinit var application: GamoonApplication

        fun getInstance(): GamoonApplication {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}