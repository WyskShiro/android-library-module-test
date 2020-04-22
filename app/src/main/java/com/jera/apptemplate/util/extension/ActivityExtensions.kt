package com.jera.apptemplate.util.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.MenuItem
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.jera.apptemplate.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

private const val STARTED_FOR_RESULT = "STARTED_FOR_RESULT"

// intents

fun Activity.addStartedForResultFlag(intent: Intent): Intent {
    return intent.putExtra(STARTED_FOR_RESULT, true)
}

fun Activity.isStartedForResult(): Boolean {
    return intent.getBooleanExtra(STARTED_FOR_RESULT, false)
}

// appbar

fun AppCompatActivity.showHomeButton() {
    supportActionBar!!.setDisplayShowHomeEnabled(true)
    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
}

// menus

fun Activity.handleMenuItemClick(item: MenuItem): Boolean {
    return handleHomeButtonClick(item)
}

fun Activity.handleHomeButtonClick(item: MenuItem): Boolean {
    if (item.itemId == android.R.id.home) {
        finish()
        return true
    }
    return false
}

// Toolbar
fun AppCompatActivity.setupToolbar(
    toolbar: Toolbar?,
    showHome: Boolean = true,
    title: String? = null
) {
    if (title != null) {
        setupToolbarWithTitle(toolbar, title, showHome)
    } else {
        setupToolbar(toolbar, showHome)
    }
}

private fun AppCompatActivity.setupToolbar(toolbar: Toolbar?, showHome: Boolean) {
    toolbar?.let { setSupportActionBar(it) }
    supportActionBar?.run {
        setDisplayHomeAsUpEnabled(showHome)
        setDisplayShowHomeEnabled(showHome)
        setDisplayShowTitleEnabled(false)
    }
}

private fun AppCompatActivity.setupToolbarWithTitle(
    toolbar: Toolbar?,
    title: String,
    showHome: Boolean
) {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        toolbar?.title = title
        setDisplayHomeAsUpEnabled(showHome)
        setDisplayShowHomeEnabled(showHome)
    }
}

// SoftKeyboard
fun AppCompatActivity.hideSoftKeyboard() {
    currentFocus?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun AppCompatActivity.showSoftKeyboard() {
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
}

// exceptions
class NotAnEasyImageIntentException : Exception()
