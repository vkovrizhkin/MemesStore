package com.kovrizhkin.memesstore.dagger.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class OkHttpModule {

    @Provides
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}