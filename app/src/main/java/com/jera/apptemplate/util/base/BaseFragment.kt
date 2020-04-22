package com.jera.apptemplate.util.base

import android.app.Dialog
import androidx.fragment.app.Fragment
import com.jera.apptemplate.util.extension.showDialog
import com.jera.apptemplate.util.navigation.NavData
import com.jera.apptemplate.util.viewmodel.DialogData

open class BaseFragment : Fragment() {

    private var dialog: Dialog? = null

    open fun onGetDialog(dialogData: DialogData?) {
        dialogData?.let {
            dialog?.dismiss()
            dialog = activity?.showDialog(it)
        }
    }

    open fun onGoTo(navData: NavData?) {
        context?.let { navData?.navigate(it) }
    }
}