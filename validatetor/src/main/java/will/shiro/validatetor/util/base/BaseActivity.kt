package will.shiro.validatetor.util.base

import android.app.Dialog
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import will.shiro.validatetor.domain.util.extension.consume
import will.shiro.validatetor.util.extension.observeEvent
import will.shiro.validatetor.util.extension.shortToast
import will.shiro.validatetor.util.extension.showDialog
import will.shiro.validatetor.util.navigation.NavData
import will.shiro.validatetor.util.viewmodel.DialogData

abstract class BaseActivity : AppCompatActivity() {

    private var dialog: Dialog? = null

    abstract val baseViewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeUi()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> consume { onBackPressed() }
            else -> super.onOptionsItemSelected(item)
        }
    }

    open fun subscribeUi() {
        baseViewModel.dialog.observeEvent(this, ::onNextDialog)
        baseViewModel.goTo.observeEvent(this, ::onGoTo)
        baseViewModel.toast.observeEvent(this, ::onNextToast)
    }

    private fun onNextDialog(dialogData: DialogData?) {
        dialog?.dismiss()
        dialog = dialogData?.let { showDialog(it) }
    }

    private fun onGoTo(navData: NavData?) {
        navData?.navigate(this)
    }

    private fun onNextToast(text: String?) {
        text?.let {
            shortToast(it)
        }
    }
}
