package com.parida.samrat.viewModel

import android.arch.lifecycle.MutableLiveData
import android.widget.EditText
import com.parida.samrat.model.ErrorDataForEditText
import com.parida.samrat.model.LoggedInUser
import com.parida.samrat.repository.LoginRepository
import com.parida.samrat.util.base.BaseViewModel

/**
 * This view model do the login validation for user
 * */
class LoginViewModel : BaseViewModel() {

    var userData:MutableLiveData<LoggedInUser> = MutableLiveData()
    var departmentLiveData:MutableLiveData<ArrayList<String>> = MutableLiveData()
    var errorDataForEditText:MutableLiveData<ErrorDataForEditText> = MutableLiveData()

    fun verifyLogIn(etMobile:EditText,etPin:EditText){
        val mobile=etMobile.text.toString()
        val pin=etPin.text.toString()
        if (mobile.isEmpty() || mobile.length < 10)
            errorDataForEditText.value = ErrorDataForEditText(etMobile.id,"Mobile must be of 10 digit")
        else if (pin.isEmpty() || pin.length < 4)
            errorDataForEditText.value = ErrorDataForEditText(etPin.id,"Pin must be of 4 digit")
        else
        verifyUserCredentials(mobile,pin)
    }

    fun verifyUserCredentials(mobile:String, pin:String){
        userData.value = LoginRepository().verifyUser(mobile,pin)
        departmentLiveData.value = userData.value!!.departmentList
    }

    companion object {
        const val DEMO_MOBILE = "0101010101"
        const val DEMO_PIN = "1010"
    }
}