package com.kovrizhkin.memesstore.dagger.components

import com.kovrizhkin.memesstore.dagger.modules.MemesApiModule
import com.kovrizhkin.memesstore.dagger.modules.OkHttpModule
import com.kovrizhkin.memesstore.repository.api.ApiService
import dagger.Component

@Component(modules = [MemesApiModule::class, OkHttpModule::class])
interface MemesComponent {
    fun getMemesApi(): ApiService
}