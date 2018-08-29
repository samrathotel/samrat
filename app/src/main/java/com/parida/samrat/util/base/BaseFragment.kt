package com.parida.samrat.util.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.parida.samrat.base.fun_defination.BaseFunctions
import com.parida.samrat.util.CommonUtil

/**
 * This fragment can be used as a parent class of any fragment*/
abstract class BaseFragment : Fragment(),BaseFunctions {
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
         return View(context!!)
     }

     override fun getSharedPref(): SharedPreferences {
         return CommonUtil.getSharedPref(context!!)!!
     }

     override fun appendLog(message: String) {
     }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        appendLog("${this.javaClass.simpleName} with $tag is attached to ${context!!.javaClass.simpleName}")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appendLog("${this.javaClass.simpleName} with $tag created")
    }

    override fun onDetach() {
        super.onDetach()
        appendLog("${this.javaClass.simpleName} with $tag has detached from ${context!!.javaClass.simpleName}")
    }
}