package com.kovrizhkin.memesstore.presenters

import com.kovrizhkin.memesstore.repository.storage.UserStorage
import com.kovrizhkin.memesstore.view.ViewContract

class SplashPresenter(val view: ViewContract.ISplashView): PresenterContract.ISplashPresenter {

    override fun checkLogin() {
        if (UserStorage.getToken().isNullOrEmpty()) view.showLoginScreen() else view.showMainScreen()
    }
}