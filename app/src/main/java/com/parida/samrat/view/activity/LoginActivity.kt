package com.parida.samrat.view.activity

import android.os.Bundle
import com.parida.samrat.App
import com.parida.samrat.R
import com.parida.samrat.util.base.BaseActivity
import com.parida.samrat.view.fragment.LoginFragment

class LoginActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_container)
        supportFragmentManager.beginTransaction()
                .replace(R.id.loginContainer,LoginFragment(),className + App.tagJoiner + LoginFragment::class.java.simpleName)
                .commit()
    }

}