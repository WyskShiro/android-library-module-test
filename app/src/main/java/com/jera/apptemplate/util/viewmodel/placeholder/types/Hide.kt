package com.jera.apptemplate.util.viewmodel.placeholder.types

import com.jera.apptemplate.util.viewmodel.placeholder.Placeholder

class Hide : Placeholder {
    override val progressVisible: Boolean
        get() = false
    override val visible: Boolean
        get() = false
    override val buttonVisible: Boolean
        get() = false
    override val messageVisible: Boolean
        get() = false
}