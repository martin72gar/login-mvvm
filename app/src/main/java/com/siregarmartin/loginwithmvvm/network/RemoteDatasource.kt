package com.siregarmartin.loginwithmvvm.network

import com.siregarmartin.loginwithmvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDatasource {

    companion object {
        private const val BASE_URL = "http://192.168.1.197:8000/api/"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor()
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(loggingInterceptor)
                }
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}