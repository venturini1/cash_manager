package com.example.cash_manager.data

import com.example.cash_manager.Tools.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email:String, password:String): Flow<Resource<AuthResult>>
    fun registerUser(email:String, password:String): Flow<Resource<AuthResult>>
}