package com.kovrizhkin.memesstore.repository.api

import com.kovrizhkin.memesstore.model.auth.AuthRequest
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    fun signUp(@Body body: AuthRequest): Call<AuthResponse>

}