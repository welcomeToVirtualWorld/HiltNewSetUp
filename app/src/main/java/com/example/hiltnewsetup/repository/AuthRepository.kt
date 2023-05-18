package com.example.hiltnewsetup.repository

import com.example.hiltnewsetup.model.UserItem
import com.example.hiltnewsetup.network.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun getFakeStuff(id:Int):Flow<Resource<UserItem>>
}