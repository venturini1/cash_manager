package com.example.cash_manager.models

import kotlinx.serialization.Serializable


@Serializable
data class Post (
    val id:Int,
    val title:String,
    val body: String,
    val userId:String
)

