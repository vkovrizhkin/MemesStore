package com.kovrizhkin.memesstore.dagger.modules

import com.kovrizhkin.memesstore.repository.api.ApiManager
import com.kovrizhkin.memesstore.repository.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [OkHttpModule::class])
class MemesApiModule {

    @Provides
    fun retrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        rxCallAdapter: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiManager.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxCallAdapter)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun memesService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun gsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun rxCallAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()
}