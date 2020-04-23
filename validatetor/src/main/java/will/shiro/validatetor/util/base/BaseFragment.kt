package will.shiro.validatetor.util.base

import android.app.Dialog
import androidx.fragment.app.Fragment
import will.shiro.validatetor.util.extension.showDialog
import will.shiro.validatetor.util.navigation.NavData
import will.shiro.validatetor.util.viewmodel.DialogData

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