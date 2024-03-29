package com.kovrizhkin.memesstore.repository.api

import com.kovrizhkin.memesstore.model.auth.AuthRequest
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import com.kovrizhkin.memesstore.model.memes.MemInfo
import io.reactivex.Observable


object Api {

    fun signUp(body: AuthRequest): Observable<AuthResponse> {
        return ApiManager.getService().signUp(body)
    }

    fun getFreshMemes(): Observable<List<MemInfo>> {
        return ApiManager.getService().getFreshMemes()
    }
}