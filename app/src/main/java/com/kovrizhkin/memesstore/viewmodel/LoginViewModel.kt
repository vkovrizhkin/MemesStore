package com.kovrizhkin.memesstore.viewmodel

import android.content.Context
import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.kovrizhkin.memesstore.model.auth.AuthRequest
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import com.kovrizhkin.memesstore.repository.api.Api
import com.kovrizhkin.memesstore.view.MemeListActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel : ViewModel() {


    var response: AuthResponse? = null

    var error: Throwable? = null

    var context: Context? = null

    var isLoading: ObservableField<Boolean> = ObservableField(false)


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
                isLoading.set(false)
                response = t

                val intent = Intent(context, MemeListActivity::class.java)
                context!!.startActivity(intent)

            }

            override fun onError(e: Throwable) {
                isLoading.set(false)
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