package com.example.hiltnewsetup.di

import com.example.hiltnewsetup.business.domain.AuthRepositoryImpl
import com.example.hiltnewsetup.business.domain.MainRepositoryImpl
import com.example.hiltnewsetup.network.auth.AuthService
import com.example.hiltnewsetup.network.main.MainService
import com.example.hiltnewsetup.repository.AuthRepository
import com.example.hiltnewsetup.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(mainService: MainService): MainRepository {
        return MainRepositoryImpl(mainService)
    }

    @Provides
    @ViewModelScoped
    fun provideAuthRepository(authService: AuthService): AuthRepository {
        return AuthRepositoryImpl(authService)
    }

    @Provides
    @ViewModelScoped
    fun provideAuthApi(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideMainService(retrofit: Retrofit): MainService {
        return retrofit.create(MainService::class.java)
    }

}