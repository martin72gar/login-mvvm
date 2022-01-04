package com.siregarmartin.loginwithmvvm.data.repository

import com.siregarmartin.loginwithmvvm.data.UserPreferences
import com.siregarmartin.loginwithmvvm.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }

    suspend fun saveAuthToken(token: String) {
        preferences.saveAuthToken(token)
    }

}