package com.kovrizhkin.memesstore.presenters

import android.annotation.SuppressLint
import com.kovrizhkin.memesstore.model.auth.AuthRequest
import com.kovrizhkin.memesstore.model.auth.AuthResponse
import com.kovrizhkin.memesstore.repository.api.Api
import com.kovrizhkin.memesstore.repository.sharedpref.SharedPrefManager
import com.kovrizhkin.memesstore.view.ViewContract
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginPresenter(private val view: ViewContract.ILoginView) :
    PresenterContract.ILoginPresenter {

    @SuppressLint("CheckResult")
    override fun onLogin(login: String, password: String) {

        val loginObservable = Api.signUp(AuthRequest(login, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


        loginObservable.subscribe(
            {
                view.onSuccessLogin()
                SharedPrefManager.saveSession(it)
            },
            {
                view.onErrorLogin(it)
            }
        )


    }

}