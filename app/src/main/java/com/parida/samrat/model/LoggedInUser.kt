package com.parida.samrat.model

/**
 * This data class holds all the details of the logged user*/
class LoggedInUser(val isDemo:Boolean,val isValid: Boolean, val userName: String,
                        val hasMultipleDepartment: Boolean,
                        val departmentList:ArrayList<String>)