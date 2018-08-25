package com.parida.samrat.viewModel

import android.arch.lifecycle.MutableLiveData
import com.parida.samrat.base.BaseViewModel
import com.parida.samrat.repository.LoginRepository

/**
 * this class is responsible for department selection event handling.
 * Created by ANIL on 25/08/18.
 */
class DepartmentViewModel :BaseViewModel(){
    var userName:String = ""
    var departmentsLiveData : MutableLiveData<Array<String>> = MutableLiveData()

    /**
     * save user name and get departments for that user*/
    fun saveUserName(userName:String){
        this.userName = userName
        departmentsLiveData.value = LoginRepository().getDepartments(userName)
    }

}