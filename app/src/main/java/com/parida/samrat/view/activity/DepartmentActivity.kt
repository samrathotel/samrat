package com.parida.samrat.view.activity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.parida.samrat.R
import com.parida.samrat.base.BaseActivity
import com.parida.samrat.databinding.DepartmentSelectionBinding
import com.parida.samrat.util.Key
import com.parida.samrat.viewModel.DepartmentViewModel

class DepartmentActivity : BaseActivity() {

    private lateinit var binding: DepartmentSelectionBinding
    private lateinit var departmentViewModel: DepartmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var userName = ""
        try {
            userName = intent.getStringExtra(Key.USER_NAME)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding=DataBindingUtil.setContentView(this, R.layout.department_selection)
        departmentViewModel = ViewModelProviders.of(this).get(DepartmentViewModel::class.java)
        departmentViewModel.saveUserName(getString(R.string.hi) +" "+ userName)
        binding.departmentViewModel = departmentViewModel

        observeDepartmentData(departmentViewModel.departmentsLiveData)
    }

    private fun observeDepartmentData(departmentsLiveData: MutableLiveData<Array<String>>) {
        departmentsLiveData.observe(this, Observer {

        })
    }
}
