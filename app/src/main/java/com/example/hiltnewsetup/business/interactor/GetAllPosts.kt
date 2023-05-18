package com.example.hiltnewsetup.business.interactor

import com.example.hiltnewsetup.model.Posts
import com.example.hiltnewsetup.network.Resource
import com.example.hiltnewsetup.repository.MainRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetAllPosts @Inject constructor(
    private val mainRepository: MainRepository
) {

    operator fun invoke():Flow<Resource<List<Posts>>>{
        return mainRepository.getPosts()
    }
}