package com.jera.apptemplate.domain.form.validation

import java.io.File

class AvatarPathValidation(
    override val isRequired: Boolean = true
) : com.jera.apptemplate.domain.form.validation.BaseValidation {

    override var text: String? = null

    override fun isValid(): Boolean {
        return text?.run { isExistentPath } ?: false
    }

    private val String?.isExistentPath: Boolean
        get() = this?.run { (File(this).run { exists() && isFile }) } ?: true
}