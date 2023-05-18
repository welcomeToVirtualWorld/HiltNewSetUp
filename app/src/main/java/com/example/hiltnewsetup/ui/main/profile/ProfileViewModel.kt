package com.example.hiltnewsetup.ui.main.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(

):ViewModel() {

    init {

        println("profile view model is ready...")
    }


}