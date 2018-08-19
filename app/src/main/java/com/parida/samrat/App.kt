package com.parida.samrat

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        const val tagJoiner = "^^"
        const val logInPinLength = 4
        const val DEPARTMENT_KITCHEN = "kitchen"
        const val DEPARTMENT_MANAGER = "manager"
        const val DEPARTMENT_WAITER = "waiter"
    }
}