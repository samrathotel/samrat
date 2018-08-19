package com.parida.samrat.base.fun_defination

interface BasePreferenceFunctions {
    fun readFromPreference(key: String, valueType: Short, defValue: Any? = null): Any?
    fun isContainsKey(key: String): Boolean
    fun writeInPreference(key: String, value: Any): Boolean
    fun removePreference(key:String)
    fun clearPreference()
}