package com.parida.samrat.dataModel

class LoggedInUser {

    var isLoggedIn:Boolean = false
    var name:String = ""
    var department:String = ""

    constructor(isLoggedIn: Boolean, name: String, department: String) {
        this.isLoggedIn = isLoggedIn
        this.name = name
        this.department = department
    }
}