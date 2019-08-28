package com.kovrizhkin.memesstore.view.screens

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.presenters.LoginPresenter
import com.kovrizhkin.memesstore.presenters.PresenterContract
import com.kovrizhkin.memesstore.view.screens.main.MainScreenActivity
import com.kovrizhkin.memesstore.view.ViewContract
import kotlinx.android.synthetic.main.activity_login.*
import studio.carbonylgroup.textfieldboxes.ExtendedEditText
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes


class LoginActivity : AppCompatActivity(), ViewContract.ILoginView {

    override fun onErrorLogin(t: Throwable) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var presenter: PresenterContract.ILoginPresenter


    private var passwordIsVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)


        passwordTextField.endIconImageButton.setOnClickListener {
            toggleVisiblePassword()
        }

        loginButton.setOnClickListener { onButtonClick() }
    }

    override fun onSuccessLogin() {

        stopButtonLoading()

        val intent = Intent(this, MainScreenActivity::class.java)
        startActivity(intent)
    }

    private fun startButtonLoading() {
        loginButton.apply {
            isEnabled = false
            text = ""
        }

        progressBarLogin.visibility = View.VISIBLE


    }

    private fun stopButtonLoading() {

        progressBarLogin.visibility = View.GONE
        loginButton.apply {
            isEnabled = true
            text = getString(R.string.sign_in)
        }
    }

    private fun toggleVisiblePassword() {
        passwordIsVisible = !passwordIsVisible

        val method = if (passwordIsVisible) null else PasswordTransformationMethod()
        val endIconResource = if (passwordIsVisible) R.drawable.ic_eye_off else R.drawable.ic_eye_on

        passwordTextField.setEndIcon(endIconResource)
        passwordEditText.apply {
            transformationMethod = method
            setSelection(text.length)
        }


    }

    private fun onButtonClick() {

        if (fieldIsValid(passwordTextField, passwordEditText) and fieldIsValid(
                loginTextField,
                loginEditText
            )
        ) {
            startButtonLoading()
            presenter.onLogin(loginEditText.text.toString(), passwordEditText.text.toString())
        }

    }

    private fun fieldIsValid(textField: TextFieldBoxes, editText: ExtendedEditText): Boolean {
        val result = editText.text.isNotBlank()
        if (result) {
            textField.removeError()
        } else {
            textField.setError(getString(R.string.field_is_required), false)
        }

        return result

    }
}

