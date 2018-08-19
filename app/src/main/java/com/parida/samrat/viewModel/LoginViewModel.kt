package com.parida.samrat.viewModel

import android.arch.lifecycle.MutableLiveData
import com.parida.samrat.App
import com.parida.samrat.base.BaseViewModel
import com.parida.samrat.dataModel.LoggedInUser

class LoginViewModel : BaseViewModel() {

    var settingsMap:MutableLiveData<HashMap<String,String>> = MutableLiveData()
    var userData:MutableLiveData<LoggedInUser> = MutableLiveData()

    fun verifyLogIn(phoneNumber:String,loginPin:String):Boolean{
        userData.value = LoggedInUser(true,"ANIL",App.DEPARTMENT_WAITER)
//        settingsMap.value
        return true
    }
}