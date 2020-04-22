package com.jera.apptemplate.util.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputLayout
import com.jera.apptemplate.util.viewmodel.SafeClickListener

fun TextInputLayout.clearError() {
    error = null
    isErrorEnabled = false
}

fun TextInputLayout.focusOnError() {
    clearFocus()
    requestFocus()
}

// View
fun View.setOnClickListener(callback: () -> Unit) {
    val intervalInMillis = 1000
    SafeClickListener(callback, intervalInMillis).apply {
        setOnClickListener(this::onClick)
    }
}

fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

// images
fun ImageView.load(url: String) {
    load(url, placeholderRes = null)
}

fun ImageView.load(url: String, @DrawableRes placeholderRes: Int?, centerCrop: Boolean? = null) {
    load(url, placeholderRes, null, centerCrop)
}

fun ImageView.load(url: String, rounded: Boolean?, @DrawableRes placeholderRes: Int? = null) {
    load(url, placeholderRes, rounded, null)
}

fun ImageView.load(
    url: String,
    @DrawableRes placeholderRes: Int?,
    rounded: Boolean?,
    centerCrop: Boolean?
) {
    val placeholder =
        if (placeholderRes == null) null else ContextCompat.getDrawable(context, placeholderRes)
    load(url, placeholder, rounded, centerCrop)
}

fun ImageView.load(
    url: String,
    placeholderDrawable: Drawable?,
    rounded: Boolean?,
    centerCrop: Boolean?
) {
    val requestOptions = RequestOptions()
    if (placeholderDrawable != null) {
        requestOptions.placeholder(placeholderDrawable).error(placeholderDrawable)
    }
    if (rounded == true) {
        requestOptions.circleCrop()
    } else if (centerCrop == true) {
        requestOptions.centerCrop()
    } else {
        requestOptions.centerInside()
    }
    Glide.with(context).load(url).apply(requestOptions).into(this)
}

fun ImageView.centerInside(url: String?, @DrawableRes placeholderRes: Int? = null) {
    centerInside(url, placeholderRes?.let(context::getDrawable))
}

fun ImageView.centerInside(url: String?, placeholder: Drawable?) {
    load(url, placeholderOptions(placeholder).centerInside())
}

fun ImageView.centerCrop(url: String?, @DrawableRes placeholderRes: Int? = null) {
    centerCrop(url, placeholderRes?.let(context::getDrawable))
}

fun ImageView.centerCrop(url: String?, placeholder: Drawable?) {
    load(url, placeholderOptions(placeholder).centerCrop())
}

fun ImageView.circleCrop(url: String?, @DrawableRes placeholderRes: Int? = null) {
    circleCrop(url, placeholderRes?.let(context::getDrawable))
}

fun ImageView.circleCrop(url: String?, placeholder: Drawable?) {
    load(url, placeholderOptions(placeholder).circleCrop())
}

fun ImageView.load(url: String?, options: RequestOptions) {
    if (url == null) {
        Glide.with(context).clear(this)
        options.placeholderDrawable?.let(this::setImageDrawable)
    } else {
        Glide.with(context).load(url).apply(options).into(this)
    }
}

// using drawables with glide loader is required
// glide 4.0 can't com.jera.apptemplate.util.extension.load vectors properly
// more recent versions (latest is 4.2) have issues merging dex files and throw exceptions at runtime
private fun placeholderOptions(placeholder: Drawable? = null): RequestOptions {
    val requestOptions = RequestOptions()
    placeholder?.let { requestOptions.placeholder(it).error(it) }
    return requestOptions
}