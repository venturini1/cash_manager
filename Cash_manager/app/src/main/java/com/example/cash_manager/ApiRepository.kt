package com.example.cash_manager

import com.example.cash_manager.models.Post
import com.example.cash_manager.network.ApiClient.client
import com.example.cash_manager.network.ApiRoutes
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

class ApiRepository {

    suspend fun getAllPosts(): List<Post> = client.get(ApiRoutes.BLOG_POST).body()

    suspend fun createNewPost(newPost: Post): Post = client.post(ApiRoutes.BLOG_POST){
        setBody(newPost)
    }.body()

    suspend fun updatePost(id:Int, post: Post):Post = client.put(ApiRoutes.BLOG_POST+"/$id"){
        setBody(post)
    }.body()

    suspend fun deletePost(id:Int) = client.delete("${ApiRoutes.BLOG_POST}/$id")
}