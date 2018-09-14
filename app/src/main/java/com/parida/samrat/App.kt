package com.parida.samrat

import android.app.Application
import android.arch.persistence.room.Room
import com.parida.samrat.db.DataBaseSamrat

class App : Application() {
    companion object {
        const val tagJoiner = "^^"
        const val logInPinLength = 4
        const val DEPARTMENT_KITCHEN = "kitchen"
        const val DEPARTMENT_MANAGER = "manager"
        const val DEPARTMENT_WAITER = "waiter"
        const val DEPARTMENT_CASHIER = "cashier"

        lateinit var db: DataBaseSamrat
    }

    override fun onCreate() {
        super.onCreate()
        db=Room.databaseBuilder(applicationContext,DataBaseSamrat::class.java,DataBaseSamrat::javaClass.name).build()

    }


}