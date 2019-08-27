package com.kovrizhkin.memesstore.presenters

import com.kovrizhkin.memesstore.model.memes.MemInfo

interface PresenterContract {

    interface ILoginPresenter {
        fun onLogin(login: String, password: String)
    }

    interface IMemeListPresenter {
        fun updateMemesList()
        fun addToFavorites(mem: MemInfo)
        fun getFavoriteIds(): List<Int>
    }

    interface IProfilePresenter {
        fun logOut()
    }

    interface IAddMemPresenter {
        fun saveMem(mem: MemInfo)
    }

}