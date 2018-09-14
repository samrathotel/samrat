package com.parida.samrat.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.parida.samrat.db.dao.UserDao

@Database(entities = [UserDao::class],version = 1)
abstract class DataBaseSamrat : RoomDatabase() {

    abstract fun getUserDao():UserDao
}