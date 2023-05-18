package com.example.hiltnewsetup.ui.main

import androidx.lifecycle.ViewModel
import com.example.hiltnewsetup.sessionmanager.SessionStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val sessionStoreManager: SessionStoreManager
):ViewModel() {

    init {
        println("MainViewModel:::->")
    }
}