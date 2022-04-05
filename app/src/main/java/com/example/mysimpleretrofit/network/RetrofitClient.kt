package com.example.mysimpleretrofit.network

import com.example.mysimpleretrofit.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofitClient: Retrofit? = null

    private fun getClient(): Retrofit? {
        val client: OkHttpClient = OkHttpClient()
            .newBuilder()
            .build()

        retrofitClient = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_2)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofitClient
    }

    fun getNetworkInterface(): NetworkInterface? {
        return getClient()?.create(NetworkInterface::class.java)
    }
}