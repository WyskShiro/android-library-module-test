package com.jera.apptemplate.util.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jera.apptemplate.util.arch.Event
import com.jera.apptemplate.util.error.ErrorHandler
import com.jera.apptemplate.util.navigation.NavData
import com.jera.apptemplate.util.viewmodel.DialogData
import com.jera.apptemplate.util.viewmodel.placeholder.Placeholder
import com.jera.apptemplate.util.viewmodel.placeholder.types.Hide
import com.jera.apptemplate.util.viewmodel.placeholder.types.Loading
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val errorHandler: ErrorHandler by inject()

    val placeholder: LiveData<Placeholder> get() = _placeholder
    val goTo: LiveData<Event<NavData>> get() = _goTo
    val dialog: LiveData<Event<DialogData>> get() = _dialog
    val toast: LiveData<Event<String>> get() = _toast

    private val _placeholder by lazy { MutableLiveData<Placeholder>() }
    private val _goTo by lazy { MutableLiveData<Event<NavData>>() }
    private val _dialog by lazy { MutableLiveData<Event<DialogData>>() }
    private val _toast by lazy { MutableLiveData<Event<String>>() }

    protected fun setPlaceholder(placeholder: Placeholder) {
        _placeholder.postValue(placeholder)
    }

    protected fun setPlaceholder(throwable: Throwable, retryAction: (() -> Unit)? = null) {
        setPlaceholder(errorHandler.getPlaceholder(throwable, retryAction))
    }

    protected fun setDialog(dialogData: DialogData) {
        _dialog.postValue(Event(dialogData))
    }

    protected fun setDialog(
        throwable: Throwable,
        retryAction: (() -> Unit)? = null,
        onDismiss: (() -> Unit)? = null
    ) {
        setDialog(errorHandler.getDialogData(throwable, retryAction, onDismiss))
    }

    protected fun goTo(navData: NavData) {
        _goTo.postValue(Event(navData))
    }

    protected fun launchDataLoad(
        shouldLoad: Boolean = true,
        onFailure: (Throwable) -> Unit,
        block: suspend () -> Unit
    ): Job {
        return viewModelScope.launch {
            try {
                if (shouldLoad) setPlaceholder(Loading())
                block()
            } catch (error: Throwable) {
                onFailure(error)
            } finally {
                setPlaceholder(Hide())
            }
        }
    }
}