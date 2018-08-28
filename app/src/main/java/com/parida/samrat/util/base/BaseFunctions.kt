package com.parida.samrat.base.fun_defination

import android.content.SharedPreferences
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import java.util.*

/**
 * This class contains all the base function defination which are all common for going to
 * used by other base class interfaces.
 * Created by ANIL on 24/05/18.
 */
interface BaseFunctions{

    /**
     * helps to show short toast .
     * @param message display in the toast
     * */
    fun showShortToast(message: String)
    /**
     * helps to show long toast.
     * @param message display in the toast
     * */
    fun showLongToast(message: String,duration: Int = Toast.LENGTH_LONG)
    /**
     * helps to show keyboard.
     * @param view on react to which the keyboard will display
     * */
    fun showSoftKeyboard(view: View)
    /**
     * helps to hide keyboard if it is opened.
     * */
    fun hideSoftKeyboard(view:View? = null)
    /**
     * helps to build a inflated layout.
     * @param layout layout resource id
     * @return the inflated view
     * */
    fun getInflatedView(layout: Int): View

    fun getSharedPref():SharedPreferences
}