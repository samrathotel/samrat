package com.parida.samrat.viewModel

import android.arch.lifecycle.MutableLiveData
import android.widget.EditText
import com.parida.samrat.App
import com.parida.samrat.base.BaseViewModel
import com.parida.samrat.dataModel.ErrorData
import com.parida.samrat.dataModel.LoggedInUser
/**
 * This view model do the login validation for user
 * */
class LoginViewModel : BaseViewModel() {

    var settingsMap:MutableLiveData<HashMap<String,String>> = MutableLiveData()
    var userData:MutableLiveData<LoggedInUser> = MutableLiveData()
    var errorData:MutableLiveData<ErrorData> = MutableLiveData()

    fun verifyLogIn(etMobile:EditText,etPin:EditText){
        val mobile=etMobile.text.toString()
        val pin=etPin.text.toString()
        if (mobile.isEmpty() || mobile.length < 10)
            errorData.value = ErrorData(etMobile,"Wrong Mobile")
        else if (pin.isEmpty() || pin.length < 4)
            errorData.value = ErrorData(etPin,"Wrong pin")
        else
        userData.value = LoggedInUser(true,"ANIL",App.DEPARTMENT_WAITER)
    }
}