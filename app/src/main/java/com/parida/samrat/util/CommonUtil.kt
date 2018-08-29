package com.parida.samrat.util

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import com.parida.samrat.R

class CommonUtil {
    companion object {
        fun showToast(context: Context,message:String,duration:Int){
            Toast.makeText(context,message,duration).show()
        }
        fun getSharedPref(context: Context): SharedPreferences? {
            return context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        }

    }
}