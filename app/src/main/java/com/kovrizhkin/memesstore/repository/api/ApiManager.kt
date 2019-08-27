package com.kovrizhkin.memesstore.repository.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    private var apiService: ApiService? = null

    fun getService(): ApiService {


        if (apiService == null) {

            val okHttpClient = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService!!
    }

    private const val BASE_URL = " https://demo3161256.mockable.io/"
}