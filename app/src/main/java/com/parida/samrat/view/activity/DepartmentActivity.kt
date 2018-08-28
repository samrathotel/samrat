package com.parida.samrat.view.activity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.parida.samrat.R
import com.parida.samrat.util.base.BaseActivity
import com.parida.samrat.databinding.DepartmentSelectionBinding
import com.parida.samrat.util.Key
import com.parida.samrat.view.adapter.DepartmentAdapter
import com.parida.samrat.viewModel.DepartmentViewModel

/**
 * This activity is for department selection for user if he has accessible for multiple departments.*/
class DepartmentActivity : BaseActivity(), DepartmentAdapter.ActivityCallback {
    override fun onDepartmentSelected(department: String) {
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra(Key.DEPARTMENT,department)
        startActivity(intent)
    }

    private lateinit var binding: DepartmentSelectionBinding
    private lateinit var departmentViewModel: DepartmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // getting logged in user name form login page
        var userName = ""
        try {
            userName = intent.getStringExtra(Key.USER_NAME)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        // creating binding and viewModel instances.
        binding=DataBindingUtil.setContentView(this, R.layout.department_selection)
        departmentViewModel = ViewModelProviders.of(this).get(DepartmentViewModel::class.java)
        departmentViewModel.saveUserName(getString(R.string.hi) +" "+ userName)
        binding.departmentViewModel = departmentViewModel

        // observing data
        observeDepartmentData(departmentViewModel.departmentsLiveData)
    }

    private fun observeDepartmentData(departmentsLiveData: MutableLiveData<ArrayList<String>>) {
        departmentsLiveData.observe(this, Observer {
            binding.rvDepartment.adapter = DepartmentAdapter(this@DepartmentActivity, it!!)
        })
    }
}
