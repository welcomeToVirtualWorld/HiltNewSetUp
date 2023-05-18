package com.example.hiltnewsetup.repository

import com.example.hiltnewsetup.model.Posts
import com.example.hiltnewsetup.network.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getPosts(): Flow<Resource<List<Posts>>>
}