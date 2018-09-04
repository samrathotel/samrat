package com.parida.samrat.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.parida.samrat.App
import com.parida.samrat.R
import com.parida.samrat.util.Key
import com.parida.samrat.util.base.BaseActivity

/**
 * This is the first class that launches when user clicks the app icon
 * which shows the @sample<splash_with_logo> screen for 2 sec and then
 * redirects to LoginFragment.
 * */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // when first time app is installed and launched
        if (getSharedPref().getBoolean(Key.FIST_TIME, true)) {
            getSharedPref().edit().putBoolean(Key.FIST_TIME, false).apply()
            setContentView(R.layout.splash_with_logo)

            // after 2 sec redirecting to log in screen
            Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
            }, 2000)
        }
        // next time onwards remove splash screen
        // check if user has already logged in show home page or ask him to login.
        else {
            val userName = getSharedPref().getString(Key.USER_NAME, "")
            val department = getSharedPref().getString(Key.DEPARTMENT,"")
            if (userName.isEmpty() || department.isEmpty())
                startActivity(Intent(this, LoginActivity::class.java))
            else {
                val intent = Intent(this, when(department) {
                    // TODO open respective main activity according to department
                 App.DEPARTMENT_KITCHEN -> MainActivityKitchen::class.java
                    else -> MainActivity::class.java
                })
                intent.putExtra(Key.USER_NAME, userName)
                intent.putExtra(Key.DEPARTMENT,department)
                startActivity(intent)
            }
        }
    }
}
