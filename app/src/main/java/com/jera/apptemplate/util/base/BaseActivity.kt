package com.jera.apptemplate.util.base

import android.app.Dialog
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jera.apptemplate.domain.util.extension.consume
import com.jera.apptemplate.util.extension.observeEvent
import com.jera.apptemplate.util.extension.shortToast
import com.jera.apptemplate.util.extension.showDialog
import com.jera.apptemplate.util.navigation.NavData
import com.jera.apptemplate.util.viewmodel.DialogData

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
