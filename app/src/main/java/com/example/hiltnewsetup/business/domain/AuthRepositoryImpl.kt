package com.example.hiltnewsetup.business.domain

import com.example.hiltnewsetup.model.UserItem
import com.example.hiltnewsetup.network.DThrowable
import com.example.hiltnewsetup.network.Resource
import com.example.hiltnewsetup.network.auth.AuthService
import com.example.hiltnewsetup.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthService
): AuthRepository {


    override fun getFakeStuff(id:Int): Flow<Resource<UserItem>> {
        return flow {
            emit(Resource.Loading())
            val result = authApi.getFakeStuff(id)
            if (result.isSuccessful && result.body()!=null){
                emit(Resource.Success(result.body()))
            }else{
                emit(Resource.Error(DThrowable(result.code(),result.message())))
            }
        }

    }


}