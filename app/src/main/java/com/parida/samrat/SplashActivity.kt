package com.parida.samrat

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.parida.samrat.base.BaseActivity
import com.parida.samrat.databinding.ActivitySplashBinding
import com.parida.samrat.util.PrefKey
import com.parida.samrat.view.CloseDialog
import com.parida.samrat.view.LoginActivity

class SplashActivity : BaseActivity() {
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnKot,R.id.btnWot,R.id.btnPos ->{
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_with_logo)

        Handler().postDelayed({
            if (getSharedPref().getBoolean(PrefKey.DEPARTMENT_SELECTION,false)){
                val binding: ActivitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
                binding.onClickListeners = this
            }else
                startActivity(Intent(this,LoginActivity::class.java))
        },2000)

    }

    override fun onBackPressed() {
        if (getSharedPref().getBoolean(PrefKey.APP_CLOSE,true))
            this.finish()
        else
        CloseDialog().show(supportFragmentManager,tag + App.tagJoiner + CloseDialog::class.java.simpleName)
    }
}
