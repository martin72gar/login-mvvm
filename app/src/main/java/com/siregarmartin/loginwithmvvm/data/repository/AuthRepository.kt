package com.siregarmartin.loginwithmvvm.data.repository

import com.siregarmartin.loginwithmvvm.data.network.AuthApi

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