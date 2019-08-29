package com.kovrizhkin.memesstore.view

import com.kovrizhkin.memesstore.model.memes.MemInfo

interface ViewContract {

    interface ITabNavigatorContainer{
        fun showLoading()
        fun hideLoading()
        fun showView(tabIndex: Int)
    }

    interface ILoginView {
        fun onSuccessLogin()
        fun onErrorLogin(t: Throwable)
    }

    interface IMemListView {
        fun showMemes(memes: List<MemInfo>)
        fun showError(t: Throwable)
    }

    interface ISplashView {
        fun showLoginScreen()
        fun showMainScreen()
    }
}