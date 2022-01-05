package com.siregarmartin.loginwithmvvm.data.network

import com.siregarmartin.loginwithmvvm.data.responses.LoginResponse
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    suspend fun getUser(): LoginResponse
}