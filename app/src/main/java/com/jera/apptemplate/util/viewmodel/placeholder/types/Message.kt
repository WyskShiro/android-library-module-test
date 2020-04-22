package com.jera.apptemplate.util.viewmodel.placeholder.types

import com.jera.apptemplate.util.viewmodel.placeholder.Placeholder

class Message(val message: String) : Placeholder {
    override val progressVisible: Boolean
        get() = false
    override val visible: Boolean
        get() = true
    override val buttonVisible: Boolean
        get() = false
    override val messageVisible: Boolean
        get() = true
}