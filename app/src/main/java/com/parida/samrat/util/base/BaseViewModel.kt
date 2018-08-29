package com.parida.samrat.util.base

import android.arch.lifecycle.ViewModel

/**
 * This view model is a base for all view model who does not want any parameterized constructor*/
abstract class BaseViewModel : ViewModel() {
    var tag:String = ""

    fun addTag(viewTag:String = ""){
        tag = viewTag + this.javaClass.simpleName
    }
}