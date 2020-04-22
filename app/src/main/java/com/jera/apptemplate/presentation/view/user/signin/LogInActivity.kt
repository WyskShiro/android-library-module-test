package com.jera.apptemplate.presentation.view.user.signin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jera.apptemplate.R
import com.jera.apptemplate.databinding.ActivityLoginBinding
import com.jera.apptemplate.domain.form.user.LoginForm.Companion.EMAIL_ID
import com.jera.apptemplate.domain.form.user.LoginForm.Companion.PASSWORD_ID
import com.jera.apptemplate.util.base.BaseActivity
import com.jera.apptemplate.util.base.BaseViewModel
import com.jera.apptemplate.util.extension.observe
import com.jera.apptemplate.util.extension.setOnClickListener
import org.koin.android.viewmodel.ext.android.viewModel
import will.shiro.validatetor.return5

class LogInActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override val baseViewModel: BaseViewModel
        get() = localViewModel
    private val localViewModel: LogInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupUi()
    }

    private fun setupUi() {
        return5()
        with(binding) {
            facebookButton.setOnClickListener(localViewModel::onFacebookButtonClicked)
            googleButton.setOnClickListener(localViewModel::onGoogleButtonClicked)
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, LogInActivity::class.java)
        }
    }
}