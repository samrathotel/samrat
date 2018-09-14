package com.parida.samrat.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.parida.samrat.model.LoggedInUser

@Dao
interface UserDao {

    @Insert
    fun addLoggedInUser(loggedInUser: LoggedInUser)

    @Query("select * from LoggedInUser where mobile = :mobile")
    fun getLoggedInUserDetail(mobile:String):LoggedInUser
}