package com.kovrizhkin.memesstore.viewmodel

import androidx.lifecycle.ViewModel
import com.kovrizhkin.memesstore.model.auth.AuthRequest
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import com.kovrizhkin.memesstore.repository.api.Api
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel : ViewModel() {


    var response: AuthResponse? = null
    var error: Throwable? = null
    var isLoading: Boolean = false

    fun onLogin(login: String, password: String) {
        getObservable().subscribe(getObserver())
    }

    private fun getObserver(): DisposableObserver<AuthResponse> {

        return object : DisposableObserver<AuthResponse>() {
            override fun onComplete() {
                val i = 0
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNext(t: AuthResponse) {
                response = t
            }

            override fun onError(e: Throwable) {
                val t = e.message
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

    }

    private fun getObservable(): Observable<AuthResponse> {
        return Api.signUp(AuthRequest("aaa", "lkdflkdf"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}