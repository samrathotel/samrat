package com.parida.samrat.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore

/**
 * This data class holds all the details of the logged user*/
@Entity
class LoggedInUser(){
    @Ignore
    var isDemo:Boolean = false
    @Ignore
    var isValid: Boolean = false
    var userName: String = ""
    var mobile = ""
    @Ignore
    var hasMultipleDepartment: Boolean = false
    @Ignore
    lateinit var departmentList:ArrayList<String>

    @Ignore
    constructor( isDemo:Boolean, isValid: Boolean, userName: String,
                 hasMultipleDepartment: Boolean,mobile: String,
                 departmentList:ArrayList<String>):this(){
        this.isDemo = isDemo
        this.isValid = isValid
        this.userName = userName
        this.hasMultipleDepartment = hasMultipleDepartment
        this.departmentList = departmentList
    }
}