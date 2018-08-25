package com.parida.samrat.repository

/**
 * This class helps to validate user data and fetch user data after login.
 * All API calls for login validation is written here.
 * Created by ANIL on 25/08/18.
 */
class LoginRepository {

    fun getDepartments(userName:String): Array<String> {
        //TODO call APi for getting departments or get it from room
        return arrayOf("Cashier","Manager","Waiter","Chef")
    }
}