package com.parida.samrat.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.parida.samrat.R
import com.parida.samrat.util.base.BaseDialogFragment
import com.parida.samrat.databinding.CloseDialogBinding

/**
 * This class helps to show a dialog for close the application
 * */
class CloseDialog : BaseDialogFragment() {
    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnYes -> {
                activity!!.finish()
            }
            R.id.btnNo -> {
                dialog.dismiss()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: CloseDialogBinding = DataBindingUtil.inflate(inflater, R.layout.close_dialog, container, false)
        binding.onClickListener = this
        return binding.root
    }
}