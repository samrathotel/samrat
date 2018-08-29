package com.parida.samrat.util.base

import android.arch.lifecycle.AndroidViewModel
import com.parida.samrat.App

/**
 * This view model class is a base class all view model who wants an application context to work with*/
abstract class BaseAndroidViewModel(app:App) : AndroidViewModel(app)