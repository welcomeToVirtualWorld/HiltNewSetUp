package com.example.hiltnewsetup.ui.main.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltnewsetup.business.interactor.GetAllPosts
import com.example.hiltnewsetup.model.Posts
import com.example.hiltnewsetup.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    val getAllPosts: GetAllPosts
):ViewModel() {

    private val _data = MutableLiveData<List<Posts>>()
    val data: LiveData<List<Posts>>
        get() = _data

    init {
        println("post fragment is working....")
    }

    fun getListOfPost(){
        viewModelScope.launch {
            getAllPosts.invoke().collectLatest {
                when(it){
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        _data.postValue(it.data?: listOf())
                    }
                    is Resource.Error -> {

                    }
                }
            }
        }

    }


}