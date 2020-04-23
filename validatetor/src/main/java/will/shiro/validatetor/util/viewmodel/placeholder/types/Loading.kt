package will.shiro.validatetor.util.viewmodel.placeholder.types

import will.shiro.validatetor.util.viewmodel.placeholder.Placeholder

class Loading(val message: String? = null) : Placeholder {
    override val progressVisible: Boolean
        get() = true
    override val visible: Boolean
        get() = true
    override val buttonVisible: Boolean
        get() = false
    override val messageVisible: Boolean
        get() = message != null
}