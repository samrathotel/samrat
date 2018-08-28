package com.parida.samrat.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.parida.samrat.R
import com.parida.samrat.util.base.BaseActivity
import com.parida.samrat.model.ErrorDataForEditText
import com.parida.samrat.model.LoggedInUser
import com.parida.samrat.databinding.ActivityLoginBinding
import com.parida.samrat.util.Key
import com.parida.samrat.view.activity.DepartmentActivity
import com.parida.samrat.view.activity.MainActivity
import com.parida.samrat.viewModel.LoginViewModel

/**
 * This activity shows the login page where user has to put his mobile no and pin.
After verification of user it will move to next screen.*/
class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // creating binding and view model objects
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        // setting binding variables
        binding.logIn = loginViewModel

        // observing data
        observeErrorData(loginViewModel.errorDataForEditText)
        observeUserData(loginViewModel.userData)
    }

    /**
     * this function observes LoggedInUser data.
     * @param userData live data of user details coming via LoginViewModel.
     * */
    private fun observeUserData(userData: MutableLiveData<LoggedInUser>) {
        userData.observe(this, Observer {
            // checks if user is valid or not
            if (it!!.isValid) {
                // if user is accessible for multiple departments then asking for department selection
                // or directly going to the home page of his particular department
                if (it.hasMultipleDepartment) {
                    val userIntent = Intent(this, DepartmentActivity::class.java)
                    userIntent.putExtra(Key.USER_NAME, it.userName)
                    userIntent.putExtra(Key.DEPARTMENT_SELECTION, it.hasMultipleDepartment)
                    startActivity(userIntent)
                } else {
                    val userIntent = Intent(this, MainActivity::class.java)
                    userIntent.putExtra(Key.USER_NAME, it.userName)
                    userIntent.putExtra(Key.DEPARTMENT, it.department)
                    startActivity(userIntent)
                }

            }
        })
    }
    /**
     * observes ErrorDataForEditText
     * @param errorDataForEditText live data of ErrorDataForEditText coming via LoginViewModel
     * */
    private fun observeErrorData(errorDataForEditText: MutableLiveData<ErrorDataForEditText>) {
        errorDataForEditText.observe(this, Observer {
            val etId = it!!.etId
            when (etId) {
                binding.etLoginPin.id -> {
                    binding.etLoginPin.error = it.message
                }
                binding.etMobile.id -> {
                    binding.etMobile.error = it.message
                }
            }
        })
    }

}