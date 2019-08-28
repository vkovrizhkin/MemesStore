package com.kovrizhkin.memesstore.presenters

import com.kovrizhkin.memesstore.model.memes.MemInfo
import com.kovrizhkin.memesstore.repository.api.Api
import com.kovrizhkin.memesstore.view.ViewContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MemListPresenter(
    private val view: ViewContract.IMemListView
) : PresenterContract.IMemListPresenter {

    override fun updateMemesList() {
        val observableMemList = Api.getFreshMemes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        observableMemList.subscribe(
            {
                view.showMemes(it)
            },
            {
                view.showError(it)
            }
        )

    }

    override fun addToFavorites(mem: MemInfo) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoriteIds(): List<Int> {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return listOf()
    }

}