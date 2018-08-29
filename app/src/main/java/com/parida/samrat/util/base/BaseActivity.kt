package com.parida.samrat.util.base

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.parida.samrat.base.fun_defination.BaseFunctions
import com.parida.samrat.util.CommonUtil

@SuppressLint("Registered")
 abstract class BaseActivity : AppCompatActivity(),BaseFunctions {
    override fun appendLog(message: String) {
    }
    override fun showShortToast(message: String) {
        CommonUtil.showToast(this,message,Toast.LENGTH_SHORT)
    }

    override fun showLongToast(message: String, duration: Int) {
        CommonUtil.showToast(this,message,Toast.LENGTH_LONG)
    }

    override fun showSoftKeyboard(view: View) {

    }

    override fun hideSoftKeyboard(view: View?) {

    }

    override fun getInflatedView(layout: Int): View {
        return View(this)
    }

    override fun getSharedPref(): SharedPreferences {
        return CommonUtil.getSharedPref(this)!!
    }
    var className:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        className = this.javaClass.simpleName
        appendLog("$className created")
    }

    override fun onRestart() {
        super.onRestart()
        appendLog("$className restarted")
    }

    override fun onResume() {
        super.onResume()
        appendLog("$className resumed")
    }
}