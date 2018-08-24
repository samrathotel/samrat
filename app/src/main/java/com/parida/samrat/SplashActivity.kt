package com.parida.samrat

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.parida.samrat.base.BaseActivity
import com.parida.samrat.util.PrefKey
import com.parida.samrat.view.LoginActivity

/**
 * This is the first class that launches when user clicks the app icon
 * which shows the @sample<splash_with_logo> screen for 2 sec and then
 * redirects to LoginActivity.
 * */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // when first time app is installed and launched
        if(getSharedPref().getBoolean(PrefKey.FIST_TIME,true)){
            getSharedPref().edit().putBoolean(PrefKey.FIST_TIME,false).apply()
            setContentView(R.layout.splash_with_logo)
            Handler().postDelayed({
                startActivity(Intent(this,LoginActivity::class.java))
            },2000)
        }
        // next time onwards remove splash screen
        else{
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }
}
