package com.parida.samrat.view.fragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.parida.samrat.App
import com.parida.samrat.R
import com.parida.samrat.databinding.ActivityLoginBinding
import com.parida.samrat.model.ErrorDataForEditText
import com.parida.samrat.model.LoggedInUser
import com.parida.samrat.util.Key
import com.parida.samrat.util.base.BaseFragment
import com.parida.samrat.view.activity.MainActivityKitchen
import com.parida.samrat.vm.LoginVM

/**
 * This fragment shows the login page where user has to put his mobile no and pin.
After verification of user it will move to next screen.*/
class LoginFragment : BaseFragment() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginVM: LoginVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // creating binding and view model objects
        binding = DataBindingUtil.inflate(inflater,R.layout.activity_login,container,false)
        loginVM = ViewModelProviders.of(activity!!).get(LoginVM::class.java)

        // setting binding variables
        binding.logIn = loginVM

        // observing data
        observeErrorData(loginVM.errorDataForEditText)
        observeUserData(loginVM.userData)
        return binding.root
    }
    /**
     * this function observes LoggedInUser data.
     * @param userData live data of user details coming via LoginVM.
     * */
    private fun observeUserData(userData: MutableLiveData<LoggedInUser>) {
        userData.observe(this, Observer {
            // checks if user is valid or not
            if (it!!.isValid) {
                // if user is accessible for multiple departments then asking for department selection
                // or directly going to the home page of his particular department
                if (it.hasMultipleDepartment) {
                    activity!!.supportFragmentManager.beginTransaction()
                            .replace(R.id.loginContainer,
                                    DepartmentFragment(),"" + App.tagJoiner + DepartmentFragment::class.java.simpleName)
                            .commit()
                } else {
                    val userIntent = Intent(activity, MainActivityKitchen::class.java)
                    userIntent.putExtra(Key.USER_NAME, it.userName)
                    userIntent.putExtra(Key.DEPARTMENT, it.departmentList[0])
                    startActivity(userIntent)
                }
            }else{
                showLongToast("Wrong credentials!")
            }
        })
    }
    /**
     * observes ErrorDataForEditText
     * @param errorDataForEditText live data of ErrorDataForEditText coming via LoginVM
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