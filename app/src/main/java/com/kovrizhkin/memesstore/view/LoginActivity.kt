package com.kovrizhkin.memesstore.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.databinding.ActivityLoginBinding
import com.kovrizhkin.memesstore.presenters.LoginPresenter
import com.kovrizhkin.memesstore.presenters.PresenterContract
import com.kovrizhkin.memesstore.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import studio.carbonylgroup.textfieldboxes.ExtendedEditText
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes


class LoginActivity : AppCompatActivity(), ViewContract.ILoginView {


    private lateinit var binding: ActivityLoginBinding

    private lateinit var presenter: PresenterContract.ILoginPresenter

    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)

        // init binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        //init view-model for binding
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.context = this
        binding.viewModel = viewModel

        binding.passwordIsVisible = false
        binding.isLoading = false

        passwordTextField.endIconImageButton.setOnClickListener {
            toggleVisiblePassword()
        }

        loginButton.setOnClickListener { onButtonClick() }
    }

    override fun onSuccessLogin() {
        //stopButtonLoading()

        val intent = Intent(this, MemeListActivity::class.java)
        startActivity(intent)
    }

    private fun startButtonLoading() {
        // binding.isLoading = true

        viewModel.isLoading.set(true)
        // binding.viewModel = viewModel
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
            viewModel.onLogin("aaa", "aaa")
            //presenter.onLogin("aaa", "aaa")
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

