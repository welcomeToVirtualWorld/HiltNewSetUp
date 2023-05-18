package com.example.hiltnewsetup.sessionmanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    val gson: Gson
) {

    private val isUserLoggedIn = booleanPreferencesKey("is_logged_in")

    suspend fun setIsUserLoogedIn(userGuid: Boolean) {
        dataStore.edit { prefs -> prefs[isUserLoggedIn] = userGuid }
    }

    fun getIsUserLoogedIn(): Flow<Boolean?> {
        return dataStore.data.map { prefs -> prefs[isUserLoggedIn] }
    }

}