package com.parida.samrat.viewModel

import android.arch.lifecycle.MutableLiveData
import com.parida.samrat.util.base.BaseViewModel
import com.parida.samrat.repository.LoginRepository

/**
 * this class is responsible for department selection event handling.
 * Created by ANIL on 25/08/18.
 */
class DepartmentViewModel : BaseViewModel(){
    var userName:String = ""
    var departmentsLiveData : MutableLiveData<ArrayList<String>> = MutableLiveData()

    /**
     * save user name and get departments for that user
     * @param userName - logged in user name
     **/
    fun saveUserName(userName:String){
        this.userName = userName
        departmentsLiveData.value = LoginRepository().getDepartments(userName)
    }

}