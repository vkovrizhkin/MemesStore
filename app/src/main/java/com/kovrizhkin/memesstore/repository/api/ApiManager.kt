package com.kovrizhkin.memesstore.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    private var apiService: ApiService? = null

    fun getService(): ApiService {

        if (apiService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService!!
    }

    private const val BASE_URL = " http://demo3161256.mockable.io/"
}