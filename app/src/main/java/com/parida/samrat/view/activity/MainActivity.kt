package com.parida.samrat.view.activity

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import com.parida.samrat.R
import com.parida.samrat.util.Key
import com.parida.samrat.util.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This activity is the home activity of user where user start doing all his activities*/
class MainActivity : BaseActivity() {

    private var isClickedTwice = false
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var userName = ""
        try {
            userName = intent.getStringExtra(Key.USER_NAME)
        }catch (e:NullPointerException){
            appendLog("onCreate - intent is null.So cannot get mobile no of user.")
        }catch (e:Exception){
            appendLog("onCreate - not getting mobile no of user from the previous activity due to $e")
        }
        getSharedPref().edit().putString(Key.USER_NAME,userName).apply()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
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
