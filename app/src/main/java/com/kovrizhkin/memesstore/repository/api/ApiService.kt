package com.kovrizhkin.memesstore.repository.api

import com.kovrizhkin.memesstore.model.auth.AuthRequest
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import com.kovrizhkin.memesstore.model.memes.MemInfo
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    fun signUp(@Body body: AuthRequest): Observable<AuthResponse>

    @GET("memes")
    fun getFreshMemes(): Observable<List<MemInfo>>

}