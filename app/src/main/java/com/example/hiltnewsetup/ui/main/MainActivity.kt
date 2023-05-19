package com.example.hiltnewsetup.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.hiltnewsetup.R
import com.example.hiltnewsetup.databinding.ActivityMainBinding
import com.example.hiltnewsetup.ui.auth.AuthActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(application, "724cecf7-38a0-4755-ad0f-61a3562b0fd1", Analytics::class.java, Crashes::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.txtLogout.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.sessionStoreManager.setIsUserLoogedIn(false)
                startActivity(Intent(this@MainActivity, AuthActivity::class.java))
                finish()
            }

        }
    }
}