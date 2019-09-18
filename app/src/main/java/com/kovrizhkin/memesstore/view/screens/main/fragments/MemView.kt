package com.kovrizhkin.memesstore.view.screens.main.fragments

import com.arellomobile.mvp.MvpView
import com.kovrizhkin.memesstore.model.memes.MemInfo

interface MemView : MvpView {
    fun showMemes(memes: List<MemInfo>)
    fun showError(t: Throwable)
}