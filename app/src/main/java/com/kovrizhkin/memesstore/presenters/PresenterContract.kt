package com.kovrizhkin.memesstore.presenters

interface PresenterContract {

    interface ILoginPresenter {
        fun onLogin(login: String, password: String)
    }

}