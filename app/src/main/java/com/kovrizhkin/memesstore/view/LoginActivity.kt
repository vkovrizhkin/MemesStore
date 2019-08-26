package com.kovrizhkin.memesstore.view

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.databinding.ActivityLoginBinding
import com.kovrizhkin.memesstore.presenters.LoginPresenter
import com.kovrizhkin.memesstore.presenters.PresenterContract
import kotlinx.android.synthetic.main.activity_login.*
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes


class LoginActivity : AppCompatActivity(), ViewContract.ILoginView {
    override fun onSuccessLogin() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var binding: ActivityLoginBinding

    private lateinit var presenter: PresenterContract.ILoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.passwordIsVisible = false
        binding.isLoading = false

        textFieldBoxes2.endIconImageButton.setOnClickListener {
            toggleVisiblePassword()
        }



        loginButton.setOnClickListener { onButtonClick() }


    }

    private fun startButtonLoading() {
        binding.isLoading = true

        //binding.notifyPropertyChanged(BR.isLoading)
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
        Handler().postDelayed({
            stopButtonLoading()
        }, 3400)

    }


    fun setImageViewResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

    private fun validateFields() {

    }

    companion object {
        @BindingAdapter("app:app:endIcon")
        fun setEndIcon(box: TextFieldBoxes, resources: Int) {
            box.setEndIcon(resources)
        }
    }
}

