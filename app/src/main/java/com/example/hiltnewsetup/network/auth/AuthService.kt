package com.example.hiltnewsetup.network.auth

import com.example.hiltnewsetup.model.UserItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthService {

    @GET("users/{id}")
    suspend fun getFakeStuff(
        @Path("id") id:Int
    ): Response<UserItem>
}