package com.example.hiltnewsetup.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.hiltnewsetup.R
import com.example.hiltnewsetup.databinding.ActivityAuthBinding
import com.example.hiltnewsetup.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()

    @Inject
    lateinit var requestManager: RequestManager


    private lateinit var binding: ActivityAuthBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_auth)
        setLogo()
        binding.btnLogin.setOnClickListener {
            attemptLogin()
        }
        viewModel.authUser.observe(this) {
            startActivity(Intent(this, MainActivity::class.java))
        }
        handleLoader()
    }

    private fun handleLoader() {
        viewModel.loading.observe(this){
            if (it){
                binding.progress.visibility = View.VISIBLE
            }else{
                binding.progress.visibility = View.GONE
            }
        }
    }

    private fun attemptLogin() {
        if (TextUtils.isEmpty(binding.edtUsername.text.toString())){
            return
        }
        viewModel.getUSer(binding.edtUsername.text.toString().toInt())

    }

    fun setLogo(){
        requestManager.load("https://goo.gl/gEgYUd").into(binding.image)
    }
}