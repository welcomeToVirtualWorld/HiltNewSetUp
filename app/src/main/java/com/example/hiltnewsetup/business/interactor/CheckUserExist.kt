package com.example.hiltnewsetup.business.interactor

import com.example.hiltnewsetup.model.UserItem
import com.example.hiltnewsetup.network.Resource
import com.example.hiltnewsetup.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class CheckUserExist @Inject constructor(
    private val authRepository: AuthRepository
){

    operator fun invoke(id:Int):Flow<Resource<UserItem>>{
        return authRepository.getFakeStuff(id)
    }

}