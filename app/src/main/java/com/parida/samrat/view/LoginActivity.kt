package com.parida.samrat.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.parida.samrat.App
import com.parida.samrat.R
import com.parida.samrat.base.BaseActivity
import com.parida.samrat.databinding.ActivityLoginBinding
import com.parida.samrat.util.PrefKey
import com.parida.samrat.viewModel.LoginViewModel

class LoginActivity : BaseActivity() {
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.fabLogin -> {
                val phoneNumber = binding.etMobile.text.toString()
                val logInPin = binding.etLoginPin.text.toString()
                if (phoneNumber.isEmpty() || phoneNumber.length < 10){
                    binding.etMobile.error = "Incorrect Mobile"
                    return
                }
                if (logInPin.isEmpty() || logInPin.length < App.logInPinLength){
                    binding.etLoginPin.error = "Incorrect Pin"
                    return
                }
                val loginSuccess = loginViewModel.verifyLogIn(phoneNumber, logInPin)
                if (loginSuccess){
                    val noOfTables = getSharedPref().getInt(PrefKey.NO_OF_TABLES,10)

                }
            }
        }
    }
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel=ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.onClickListener = this
    }


}