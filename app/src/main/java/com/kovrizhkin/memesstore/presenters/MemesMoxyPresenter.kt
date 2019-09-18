package com.kovrizhkin.memesstore.presenters


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.kovrizhkin.memesstore.repository.api.Api
import com.kovrizhkin.memesstore.view.screens.main.fragments.MemView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class MemesMoxyPresenter : MvpPresenter<MemView>() {

    fun updateMemesList() {
        val observableMemList = Api.getFreshMemes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        observableMemList.subscribe(
            {
                viewState.showMemes(it)
            },
            {
                viewState.showError(it)
            }
        )

    }

/*    fun addToFavorites(mem: MemInfo) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getFavoriteIds(): List<Int> {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return listOf()
    }*/

}