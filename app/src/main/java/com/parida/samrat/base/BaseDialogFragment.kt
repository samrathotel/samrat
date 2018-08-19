package com.parida.samrat.base

import android.app.DialogFragment
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.parida.samrat.base.fun_defination.BaseFunctions
import com.parida.samrat.util.CommonUtil

abstract class BaseDialogFragment : android.support.v4.app.DialogFragment(),BaseFunctions,View.OnClickListener {
     override fun showShortToast(message: String) {
         CommonUtil.showToast(context!!,message,Toast.LENGTH_SHORT)
     }

     override fun showLongToast(message: String, duration: Int) {
         CommonUtil.showToast(context!!,message,Toast.LENGTH_LONG)
     }

     override fun showSoftKeyboard(view: View) {

     }

     override fun hideSoftKeyboard(view: View?) {

     }

     override fun getInflatedView(layout: Int): View {
         return  View(context)
     }

     override fun getSharedPref(): SharedPreferences {
         return CommonUtil.getSharedPref(context!!)!!
     }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}