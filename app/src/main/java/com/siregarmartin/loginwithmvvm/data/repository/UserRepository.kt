package com.siregarmartin.loginwithmvvm.data.repository

import com.siregarmartin.loginwithmvvm.data.UserPreferences
import com.siregarmartin.loginwithmvvm.data.network.AuthApi
import com.siregarmartin.loginwithmvvm.data.network.UserApi

class UserRepository(
    private val api: UserApi
) : BaseRepository() {

    suspend fun getUser() = safeApiCall {
        api.getUser()
    }

}