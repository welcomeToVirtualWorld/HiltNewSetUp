package com.example.hiltnewsetup.network.main

import com.example.hiltnewsetup.model.Posts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("posts")
    suspend fun getAllPosts(
        @Query("userId") id:Int
    ): Response<List<Posts>>
}