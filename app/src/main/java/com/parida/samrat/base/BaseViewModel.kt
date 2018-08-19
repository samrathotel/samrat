package com.parida.samrat.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    var tag:String = ""

    fun addTag(viewTag:String = ""){
        tag = viewTag + this.javaClass.simpleName
    }
}