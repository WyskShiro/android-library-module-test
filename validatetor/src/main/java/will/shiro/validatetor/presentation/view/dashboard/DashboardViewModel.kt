package will.shiro.validatetor.presentation.view.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import will.shiro.validatetor.domain.entity.Pokemon
import will.shiro.validatetor.domain.interactors.GetPokemon
import will.shiro.validatetor.util.base.BaseViewModel
import kotlin.random.Random
import kotlin.random.nextLong

class DashboardViewModel constructor(
    private val getPokemon: GetPokemon
) : BaseViewModel() {

    val pokemon: LiveData<Pokemon> get() = _pokemon
    val error: LiveData<String> get() = _error

    private val _pokemon by lazy { MutableLiveData<Pokemon>() }
    private val _error by lazy { MutableLiveData<String>() }

    fun getMyPokemon() {
        viewModelScope.launch {
            try {
                val pokemon = getPokemon.execute(Random.nextLong(1L..151))
                _pokemon.value = pokemon
            } catch (e: Exception) {
                _error.value = e.message ?: "Deu zika"
            }
        }
    }
}