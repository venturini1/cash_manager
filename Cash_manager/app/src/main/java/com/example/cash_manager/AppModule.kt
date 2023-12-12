//package com.example.cash_manager
//
//import android.content.Context
//import com.google.android.datatransport.runtime.dagger.Module
//import com.google.android.datatransport.runtime.dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import kotlinx.coroutines.Dispatchers
//import javax.inject.Qualifier
//import javax.inject.Singleton
//
//
//@InstallIn(SingletonComponent::class)
//@Module
//object AppModules {
//
//    @Singleton
//    @Provides
//    @IoDispatcher
//    fun provideIoDispatcher() = Dispatchers.IO
//    @Provides
//    fun provideBarcodeScanner(@ApplicationContext appContext: Context) = BarcodeScanner(appContext)
//
//}
//
//@Retention(AnnotationRetention.RUNTIME)
//@Qualifier
//annotation class IoDispatcher