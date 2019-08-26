package com.kovrizhkin.memesstore.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
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

    override fun onSuccessLogin() {
        stopButtonLoading()
    }

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
        startButtonLoading()

        presenter.onLogin("aaa", "aaa")
        /*if (fieldIsValid(passwordTextField) and fieldIsValid(loginTextField)) {

        }*/

    }

    private fun fieldIsValid(textField: TextFieldBoxes): Boolean {
        val result = (textField.children.first() as ExtendedEditText).text.isNotBlank()

        if (result) {
            textField.removeError()
        } else {
            textField.setError(getString(R.string.field_is_required), false)
            return false
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

