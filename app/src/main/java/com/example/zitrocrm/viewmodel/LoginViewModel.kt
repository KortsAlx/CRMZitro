package com.example.zitrocrm.viewmodel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.zitrocrm.MainActivity
import com.example.zitrocrm.network.models_dto.SalasNuevoReporte.SampleData
import com.example.zitrocrm.network.models_dto.Login.LoginDto
import com.example.zitrocrm.network.repository.RetrofitHelper
import com.example.zitrocrm.repository.DataStorePreferenceRepository
import com.example.zitrocrm.repository.DataStoreViewModel
import com.example.zitrocrm.utils.SharedPrefence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel (
) : ViewModel() {
    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    private val loginRequestLiveData = MutableLiveData<Boolean>()

    fun login(user: String, pwd: String, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                delay(1500L)
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getLogin(LoginDto(usuario = user, pwd = pwd))

                if (responseService.ok) {
                    
                    val token = responseService.token

                    val dataStorePreferenceRepository = SharedPrefence(context)


                    dataStorePreferenceRepository.saveUser(user, pwd, responseService.usuario, token)

                    isSuccessLoading.value = true


                } else {
                    /*responseService.errorBody()?.let { error ->
                        imageErrorAuth.value = true
                        //delay(1500L)
                        imageErrorAuth.value = false
                        error.close()
                    }*/
                }

                //loginRequestLiveData.postValue(responseService.isSuccessful)
                progressBar.value = false
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
                progressBar.value = false
            }
        }
    }


    private val _cards = MutableStateFlow(listOf<SampleData>())
    val cards: StateFlow<List<SampleData>> get() = _cards
    private val _cards2 = MutableStateFlow(listOf<SampleData>())
    val cards2: StateFlow<List<SampleData>> get() = _cards2
    private val _cards3 = MutableStateFlow(listOf<SampleData>())
    val cards3: StateFlow<List<SampleData>> get() = _cards3
    private val _cards4 = MutableStateFlow(listOf<SampleData>())
    val cards4: StateFlow<List<SampleData>> get() = _cards4
    private val _cards5 = MutableStateFlow(listOf<SampleData>())
    val cards5: StateFlow<List<SampleData>> get() = _cards5
    private val _cards6 = MutableStateFlow(listOf<SampleData>())
    val cards6: StateFlow<List<SampleData>> get() = _cards6
    private val _cards7 = MutableStateFlow(listOf<SampleData>())
    val cards7: StateFlow<List<SampleData>> get() = _cards7
    private val _cards8 = MutableStateFlow(listOf<SampleData>())
    val cards8: StateFlow<List<SampleData>> get() = _cards8
    private val _cards9 = MutableStateFlow(listOf<SampleData>())
    val cards9: StateFlow<List<SampleData>> get() = _cards9

    private val _expandedCardList = MutableStateFlow(listOf<Int>())
    val expandedCardList: StateFlow<List<Int>> get() = _expandedCardList

    init {
        getSampleData()
    }

    private fun getSampleData() {
        viewModelScope.launch(Dispatchers.Default) {
            val sampleList = arrayListOf<SampleData>()
            val sampleList2 = arrayListOf<SampleData>()
            val sampleList3 = arrayListOf<SampleData>()
            val sampleList4 = arrayListOf<SampleData>()
            val sampleList5 = arrayListOf<SampleData>()
            val sampleList6 = arrayListOf<SampleData>()
            val sampleList7 = arrayListOf<SampleData>()
            val sampleList8 = arrayListOf<SampleData>()
            val sampleList9 = arrayListOf<SampleData>()

            sampleList += SampleData(
                id =  1,
                title = "Visita Promotores",
            )
            _cards.emit(sampleList)

            sampleList2 += SampleData(
                id =  2,
                title = "Detalle Ocupación"
            )
            _cards2.emit(sampleList2)

            sampleList3 += SampleData(
                id =  3,
                title = "Objetivo de la Visita"
            )
            _cards3.emit(sampleList3)

            sampleList4 += SampleData(
                id =  4,
                title = "Acumulados Bingo"
            )
            _cards4.emit(sampleList4)

            sampleList5 += SampleData(
                id =  5,
                title = "Lo más jugado Zitro y competencia"
            )
            _cards5.emit(sampleList5)

            sampleList6 += SampleData(
                id =  6,
                title = "Comentarios Generales Jugadores"
            )
            _cards6.emit(sampleList6)

            sampleList7 += SampleData(
                id =  7,
                title = "Comentarios Sonido Nuestras Máquinas y Proveedores Cercanos"
            )
            _cards7.emit(sampleList7)

            sampleList8 += SampleData(
                id =  8,
                title = "Observaciones Competencia"
            )
            _cards8.emit(sampleList8)

            sampleList9 += SampleData(
                id =  9,
                title = "Folios Técnicos"
            )
            _cards9.emit(sampleList9)
        }
    }

    fun cardArrowClick(cardId: Int) {
        _expandedCardList.value = _expandedCardList.value.toMutableList().also { list ->
            if (list.contains(cardId)) {
                list.remove(cardId)
            } else {
                list.add(cardId)
            }
        }
    }

   /** fun filter(){
        try {
            progressBar.value = true
            val authService = RetrofitHelper.getAuthService()
            val responsefilter_regiones = authService.getRegiones()
        }
    }**/
}

fun DataStoreInput(viewModel : DataStoreViewModel){

}
