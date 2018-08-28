package com.parida.samrat.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.parida.samrat.BR
import com.parida.samrat.R
import com.parida.samrat.databinding.RowDepartmentBinding

class DepartmentAdapter(private val callBack:ActivityCallback,private val list:ArrayList<String>): RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val binding = DataBindingUtil.inflate<RowDepartmentBinding>(LayoutInflater.from(parent.context), R.layout.row_department, parent, false)
        return  DepartmentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class DepartmentViewHolder(private val binding : RowDepartmentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(row:String){
            binding.setVariable(BR.department,row)
            binding.executePendingBindings()
        }

        fun onDepartmentSelected(department:String){
            callBack.onDepartmentSelected(department)
        }
    }

    interface ActivityCallback{
        fun onDepartmentSelected(department:String)
    }
}