package com.parida.samrat.viewModel

import android.arch.lifecycle.MutableLiveData
import android.widget.EditText
import com.parida.samrat.App
import com.parida.samrat.base.BaseViewModel
import com.parida.samrat.dataModel.ErrorDataForEditText
import com.parida.samrat.dataModel.LoggedInUser
/**
 * This view model do the login validation for user
 * */
class LoginViewModel : BaseViewModel() {

    var settingsMap:MutableLiveData<HashMap<String,String>> = MutableLiveData()
    var userData:MutableLiveData<LoggedInUser> = MutableLiveData()
    var errorDataForEditText:MutableLiveData<ErrorDataForEditText> = MutableLiveData()

    fun verifyLogIn(etMobile:EditText,etPin:EditText){
        val mobile=etMobile.text.toString()
        val pin=etPin.text.toString()
        if (mobile.isEmpty() || mobile.length < 10)
            errorDataForEditText.value = ErrorDataForEditText(etMobile.id,"Wrong Mobile")
        else if (pin.isEmpty() || pin.length < 4)
            errorDataForEditText.value = ErrorDataForEditText(etPin.id,"Wrong pin")
        //TODO  verify user from server and local
        else
        userData.value = LoggedInUser(true,"ANIL",true,App.DEPARTMENT_WAITER)
    }
}