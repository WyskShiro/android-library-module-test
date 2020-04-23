package will.shiro.validatetor.presentation.view.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import will.shiro.validatetor.R
import will.shiro.validatetor.util.extension.shortToast

internal class DashboardActivity : AppCompatActivity() {

    private val url by lazy {
        intent!!.extras!!.getString("URL")
    }

    private val viewModel by viewModels<DashboardViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val button = findViewById<Button>(R.id.pokemon_button)
        button.setOnClickListener {
            shortToast(url)
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, DashboardActivity::class.java)
        }
    }
}