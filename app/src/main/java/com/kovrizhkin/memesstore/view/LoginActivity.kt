package com.kovrizhkin.memesstore.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.databinding.ActivityLoginBinding
import com.kovrizhkin.memesstore.presenters.LoginPresenter
import com.kovrizhkin.memesstore.presenters.PresenterContract
import kotlinx.android.synthetic.main.activity_login.*
import studio.carbonylgroup.textfieldboxes.ExtendedEditText
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes


class LoginActivity : AppCompatActivity(), ViewContract.ILoginView {


    private lateinit var binding: ActivityLoginBinding

    private lateinit var presenter: PresenterContract.ILoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.passwordIsVisible = false
        binding.isLoading = false

        passwordTextField.endIconImageButton.setOnClickListener {
            toggleVisiblePassword()
        }

        loginButton.setOnClickListener { onButtonClick() }
    }

    override fun onSuccessLogin() {

        stopButtonLoading()

        val intent = Intent(this, MemeListActivity::class.java)
        startActivity(intent)
    }

    private fun startButtonLoading() {
        binding.isLoading = true

    }

    private fun stopButtonLoading() {
        binding.isLoading = false
        //binding.notifyPropertyChanged(BR.isLoading)
    }

    private fun toggleVisiblePassword() {
        binding.passwordIsVisible = !binding.passwordIsVisible!!
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

    companion object {

        @JvmStatic
        @BindingAdapter("endIcon")
        fun TextFieldBoxes.bindEndIcon(resources: Int) {
            setEndIcon(resources)
        }
    }
}

