package com.parida.samrat.dataModel

/**
 * This data class holds all the details of the logged user*/
data class LoggedInUser(val isValid: Boolean, val userName: String,
                        val hasMultipleDepartment: Boolean,
                        val department:String)