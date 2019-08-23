package com.kovrizhkin.memesstore.repository.api

import com.kovrizhkin.memesstore.model.auth.AuthRequest
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Api {

    fun signUp(body: AuthRequest) {

        val call = ApiManager().getService().signUp(body)

        call.enqueue(object : Callback<AuthResponse> {
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
               //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}