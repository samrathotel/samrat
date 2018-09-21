package com.parida.samrat.view.fragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.parida.samrat.App
import com.parida.samrat.R
import com.parida.samrat.databinding.DepartmentSelectionBinding
import com.parida.samrat.util.Key
import com.parida.samrat.util.base.BaseFragment
import com.parida.samrat.view.activity.MainActivity
import com.parida.samrat.view.activity.MainActivityKitchen
import com.parida.samrat.view.adapter.DepartmentAdapter
import com.parida.samrat.vm.LoginVM
import kotlinx.android.synthetic.main.department_selection.view.*

/**
 * This activity is for department selection for user if he has accessible for multiple departments.*/
class DepartmentFragment : BaseFragment(), DepartmentAdapter.ActivityCallback {

    private lateinit var bindView: View
    private lateinit var loginVM: LoginVM

    override fun onDepartmentSelected(department: String) {
        // TODO open respective main activity according to department
        val intent = Intent(context, when (department){
            App.DEPARTMENT_KITCHEN -> MainActivityKitchen::class.java
            else -> MainActivity::class.java
        })
        intent.putExtra(Key.DEPARTMENT, department)
        intent.putExtra(Key.USER_NAME, loginVM.userData.value!!.userName)
        startActivity(intent)
        activity!!.supportFragmentManager.popBackStackImmediate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<DepartmentSelectionBinding>(inflater, R.layout.department_selection, container, false)
        bindView = binding.root

        loginVM = ViewModelProviders.of(activity!!).get(LoginVM::class.java)
        binding.loggedUser = loginVM.userData.value
        observeDepartmentData(loginVM.departmentLiveData)
        return bindView
    }

    private fun observeDepartmentData(departmentLiveData: MutableLiveData<ArrayList<String>>) {
        departmentLiveData.observe(this, Observer {
            bindView.rvDepartment.layoutManager = LinearLayoutManager(activity)
            bindView.rvDepartment.adapter = DepartmentAdapter(this, it!!)
        })
    }
}
