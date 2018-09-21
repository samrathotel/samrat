package com.parida.samrat.view.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import com.parida.samrat.R
import com.parida.samrat.util.Key
import com.parida.samrat.util.base.BaseActivity
import com.parida.samrat.vm.MainCommonVM
import kotlinx.android.synthetic.main.activity_main_kitchen.*

/**
 * This activity is the home activity of user where user start doing all his activities*/
class MainActivityKitchen : BaseActivity() {

    private var isClickedTwice = false
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_order -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_progress ->{
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_deliver -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    private lateinit var mainCommonVM: MainCommonVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kitchen)
        mainCommonVM=ViewModelProviders.of(this).get(MainCommonVM::class.java)
        getUserDetailAndSave()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun getUserDetailAndSave() {
        var userName = ""
        try {
            userName = intent.getStringExtra(Key.USER_NAME)
        }catch (e:NullPointerException){
            appendLog("onCreate - intent is null.So cannot get mobile no of user.")
        }catch (e:Exception){
            appendLog("onCreate - not getting mobile no of user from the previous activity due to $e")
        }
        var department = ""
        try {
            department = intent.getStringExtra(Key.DEPARTMENT)
        } catch (e: Exception) {
            appendLog("onCreate - no department has found")
        }
        if (userName.isEmpty() || department.isEmpty()){
            Handler().postDelayed({
                showLongToast(if(userName.isEmpty())"User name not found" else "department not found")
                finish()
            },3000)
        }
        else
        mainCommonVM.saveUserDetails(getSharedPref(),userName,department)
    }

    override fun onBackPressed() {

        if (isClickedTwice){
            getSharedPref().edit().putString(Key.USER_NAME,"").apply()
            super.onBackPressed()
            return
        }
        this.isClickedTwice = true
        showShortToast("Press again to logout")
        Handler().postDelayed({
            isClickedTwice = false
        },2000)
    }
}

class ForgotToDoException(name: String) : Throwable() {

}
