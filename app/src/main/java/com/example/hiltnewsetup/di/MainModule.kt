package com.example.hiltnewsetup.di

import com.example.hiltnewsetup.business.domain.MainRepositoryImpl
import com.example.hiltnewsetup.network.main.MainService
import com.example.hiltnewsetup.repository.MainRepository
import com.example.hiltnewsetup.ui.main.post.CustomAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class MainModule {



    @Provides
    @ActivityScoped
    fun provideAdapter(): CustomAdapter {
        return CustomAdapter()
    }




}