package com.example.hiltnewsetup.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltnewsetup.business.interactor.CheckUserExist
import com.example.hiltnewsetup.model.UserItem
import com.example.hiltnewsetup.network.Resource
import com.example.hiltnewsetup.network.auth.AuthService
import com.example.hiltnewsetup.sessionmanager.SessionStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    val sessionStoreManager: SessionStoreManager,
    val checkUserExist: CheckUserExist
):ViewModel() {

    val _loading by lazy {
        MutableLiveData(false)
    }

    val loading: LiveData<Boolean>
        get() = _loading


    private val _authUser = MutableLiveData<UserItem?>()
    val authUser: LiveData<UserItem?>
        get() {
            return _authUser
        }


    fun getUSer(id:Int){
        viewModelScope.launch {
            checkUserExist.invoke(id).collectLatest {
                when(it){
                    is Resource.Loading ->{
                        _loading.postValue(true)
                    }
                    is Resource.Success ->{
                        sessionStoreManager.setIsUserLoogedIn(true)
                        _loading.postValue(false)
                        _authUser.postValue(it.data)
                    }
                    is Resource.Error ->{
                        println("message"+it.throwable.message)
                        _loading.postValue(false)
                    }
                }

            }
        }

    }

}