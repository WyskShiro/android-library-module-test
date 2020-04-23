package will.shiro.validatetor.presentation.view.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import will.shiro.validatetor.R
import will.shiro.validatetor.util.extension.shortToast
import will.shiro.validatetor.util.resource.API_ENDPOINT_NAMED

internal class DashboardActivity : AppCompatActivity() {

    private val url by lazy {
        intent!!.extras!!.getString("URL")
    }

    private val viewModel by viewModel<DashboardViewModel>()
    private val apiEndPoint by inject<String>(named(API_ENDPOINT_NAMED))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val button = findViewById<Button>(R.id.pokemon_button)
        button.setOnClickListener {
            viewModel.getMyPokemon()
        }

        viewModel.pokemon.observe(this, Observer {
            shortToast(it.toString())
        })
        viewModel.error.observe(this, Observer {
            shortToast("Deu ruim: $it")
        })
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, DashboardActivity::class.java)
        }
    }
}