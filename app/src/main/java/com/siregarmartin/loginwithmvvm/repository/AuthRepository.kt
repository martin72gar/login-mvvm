package com.siregarmartin.loginwithmvvm.repository

import com.siregarmartin.loginwithmvvm.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }

}