package com.parida.samrat.repository

import com.parida.samrat.App
import com.parida.samrat.model.LoggedInUser

/**
 * This class helps to validate user data and fetch user data after login.
 * All API calls and db operation for login validation is written here.
 * Created by ANIL on 25/08/18.
 */
class LoginRepository : BaseRepository(){

    fun verifyUser(mobile: String,pin:String):LoggedInUser{
        val userFromDb = App.db.getUserDao().getLoggedInUserDetail(mobile)
        if(userFromDb.isValid){
            return userFromDb
        }else{
            //TODO call api for verifying user
            val departmentList = ArrayList<String>()
            departmentList.add(App.DEPARTMENT_MANAGER)
            departmentList.add(App.DEPARTMENT_WAITER)
            departmentList.add(App.DEPARTMENT_CASHIER)
            departmentList.add(App.DEPARTMENT_KITCHEN)
            return LoggedInUser(true,true,"Samrat",true,"7204015891", departmentList)
        }
    }
}