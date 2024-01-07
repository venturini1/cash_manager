//package com.example.cash_manager
//
//import android.app.Application
//import coil.ImageLoader
//import coil.ImageLoaderFactory
//import com.android.volley.BuildConfig
//import dagger.hilt.android.HiltAndroidApp
//import timber.log.Timber
//
//@HiltAndroidApp
//class App : Application(), ImageLoaderFactory {
//
//    override fun newImageLoader(): ImageLoader {
//        Timber.tag("test").d("i am called")
//        return ImageLoader.Builder(this)
//            .crossfade(true)
//            .build()
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        } else
//            Timber.plant(Timber.asTree())
//
//    }
//
//
//}