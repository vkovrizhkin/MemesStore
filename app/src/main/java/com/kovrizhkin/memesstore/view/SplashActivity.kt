package com.kovrizhkin.memesstore.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.kovrizhkin.memesstore.presenters.PresenterContract
import com.kovrizhkin.memesstore.presenters.SplashPresenter
import com.kovrizhkin.memesstore.view.screens.LoginActivity
import com.kovrizhkin.memesstore.view.screens.main.MainScreenActivity

class SplashActivity : AppCompatActivity(), ViewContract.ISplashView {

    lateinit var presenter: PresenterContract.ISplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({


            presenter = SplashPresenter(this)
            presenter.checkLogin()

            finish()
        }, LAUNCH_DELAY)


    }

    override fun showLoginScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun showMainScreen() {
        startActivity(Intent(this, MainScreenActivity::class.java))
        finish()
    }

    companion object {
        const val LAUNCH_DELAY = 300L
    }
}
