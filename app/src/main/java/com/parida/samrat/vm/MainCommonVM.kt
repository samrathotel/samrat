package com.parida.samrat.vm

import android.content.SharedPreferences
import com.parida.samrat.util.Key
import com.parida.samrat.util.base.BaseViewModel

class MainCommonVM : BaseViewModel() {
    private val userDetail:HashMap<String,String> = HashMap()

    fun saveUserDetails(sPref:SharedPreferences,userName:String,department:String){
        userDetail[Key.USER_NAME] = userName
        userDetail[Key.DEPARTMENT] = department
        sPref.edit().putString(Key.USER_NAME,userName).apply()
        sPref.edit().putString(Key.DEPARTMENT,department).apply()
    }
    fun getUserName():String{
        return userDetail[Key.USER_NAME]!!
    }
    fun getDepartment():String{
        return userDetail[Key.DEPARTMENT]!!
    }
}