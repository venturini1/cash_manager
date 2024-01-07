package com.example.cash_manager.DepInjection

import com.example.cash_manager.data.AuthRepository
import com.example.cash_manager.data.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Appmodule {

    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth : FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }
}