package com.kovrizhkin.memesstore.view

interface ViewContract {
    interface ILoginView {
        fun onSuccessLogin()
        fun onErrorLogin(t: Throwable)
    }
}