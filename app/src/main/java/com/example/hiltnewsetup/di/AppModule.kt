package com.example.hiltnewsetup.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.hiltnewsetup.R
import com.example.hiltnewsetup.business.domain.AuthRepositoryImpl
import com.example.hiltnewsetup.business.domain.MainRepositoryImpl
import com.example.hiltnewsetup.network.auth.AuthService
import com.example.hiltnewsetup.network.main.MainService
import com.example.hiltnewsetup.repository.AuthRepository
import com.example.hiltnewsetup.repository.MainRepository
import com.example.hiltnewsetup.sessionmanager.SessionStoreManager
import com.example.hiltnewsetup.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun gson():Gson{
        return GsonBuilder().create()
    }



    @Singleton
    @Provides
    fun dataStore(application: Application): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                application.preferencesDataStoreFile("Demo")
            }
        )

    @Singleton
    @Provides
    fun sessionStoreManager(gson: Gson, dataStore: DataStore<Preferences>):SessionStoreManager{
        return SessionStoreManager(dataStore,gson)
    }



}