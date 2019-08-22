package com.kovrizhkin.memesstore.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.kovrizhkin.memesstore.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var passwordIsVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener { onButtonClick() }


    }

    private fun startButtonLoading() {
        loginButton.isEnabled = false
        loginButton.setTextColor(resources.getColor(R.color.colorTransparent))
        progressBarLogin.visibility = View.VISIBLE
    }

    private fun stopButtonLoading() {
        progressBarLogin.visibility = View.GONE
        loginButton.setTextColor(resources.getColor(R.color.colorTextButton))
        loginButton.isEnabled = true

    }

    private fun toggleVisiblePassword() {

    }

    fun showPassword() {

    }

    fun hidePassword() {

    }

    private fun onButtonClick() {
        startButtonLoading()
        Handler().postDelayed({
            stopButtonLoading()
        }, 3000)
    }

    private fun validateFields() {

    }
}

