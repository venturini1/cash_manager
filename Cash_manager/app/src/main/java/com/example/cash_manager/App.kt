package com.example.cash_manager

import android.app.Application
import coil.ImageLoaderFactory
import coil.ImageLoader
import com.android.volley.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

class App : Application(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader {
        Timber.tag("test").d("i am called")
        return ImageLoader.Builder(this)
            .crossfade(true)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else
            Timber.plant(Timber.DebugTree())
    }
}