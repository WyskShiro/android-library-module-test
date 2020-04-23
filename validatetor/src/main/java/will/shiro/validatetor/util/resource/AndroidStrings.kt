package will.shiro.validatetor.util.resource

import android.content.Context
import android.net.Uri
import androidx.annotation.StringRes
import will.shiro.validatetor.R
import will.shiro.validatetor.domain.util.resource.Strings

class AndroidStrings constructor(context: Context) : Strings {

    private val context = context.applicationContext

    override val errorTitle: String get() = res(R.string.error_title)
    override val errorUnknown: String get() = res(R.string.error_unknown)
    override val errorNetwork: String get() = res(R.string.error_network)
    override val errorUnprocessable: String get() = res(R.string.error_unprocessable)
    override val errorUnauthorizedLoginNow: String get() = res(R.string.error_unauthorized_login_now)
    override val errorNotFound: String get() = res(R.string.error_not_found)
    override val errorNotProcessable: String get() = res(R.string.error_not_processable)
    override val errorSocketTimeout: String get() = res(R.string.error_socket_timeout)
    override val globalYes: String get() = res(R.string.global_yes)
    override val globalNo: String get() = res(R.string.global_no)
    override val globalFacebook: String get() = res(R.string.global_facebook)
    override val globalGoogle: String get() = res(R.string.global_google)
    override val globalOr: String get() = res(R.string.global_or)
    override val globalWait: String get() = res(R.string.global_wait)
    override val globalTryAgain: String get() = res(R.string.global_try_again)
    override val globalCancel: String get() = res(R.string.global_cancel)
    override val globalDoLogin: String get() = res(R.string.global_do_login)
    override val globalOk: String get() = res(R.string.global_ok)

    private fun res(@StringRes stringId: Int) = context.getString(stringId)
    private fun uriRes(resourceId: Int) = Uri.parse("android.resource://${context.packageName}/$resourceId").toString()
}