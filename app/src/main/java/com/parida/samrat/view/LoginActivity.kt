package com.parida.samrat.view

import android.arch.lifecycle.Observer
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

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel=ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.logIn = loginViewModel

        loginViewModel.errorData.observe(this, Observer {
            val etId= it!!.et.id
            when (etId){
                binding.etLoginPin.id ->{
                    binding.etLoginPin.error = it.message
                }
                binding.etMobile.id ->{
                    binding.etMobile.error = it.message
                }
            }
        })
        loginViewModel.userData.observe(this, Observer {

        })
    }

}