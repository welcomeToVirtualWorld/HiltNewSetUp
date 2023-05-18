package com.example.hiltnewsetup.business.domain

import com.example.hiltnewsetup.model.Posts
import com.example.hiltnewsetup.network.DThrowable
import com.example.hiltnewsetup.network.Resource
import com.example.hiltnewsetup.network.main.MainService
import com.example.hiltnewsetup.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainApi: MainService
): MainRepository {


    override fun getPosts(): Flow<Resource<List<Posts>>> {
        return flow {
            emit(Resource.Loading())
            val result = mainApi.getAllPosts(2)
            if (result.isSuccessful && result.body()!=null){
                emit(Resource.Success(result.body()))
            }else{
                emit(Resource.Error(DThrowable(result.code(),result.message())))
            }
        }

    }
}