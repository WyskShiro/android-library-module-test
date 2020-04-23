package will.shiro.validatetor.presentation.view

import android.content.Context
import android.content.Intent
import will.shiro.validatetor.presentation.view.dashboard.DashboardActivity

object Retriever {

    fun getDashboardActivity(context: Context, url: String): Intent {
        return Intent(context, DashboardActivity::class.java).apply {
            putExtra("URL", url)
        }
    }
}