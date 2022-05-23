package com.example.zitrocrm.network.models_dto.Filter

/**
@HiltViewModel
class FilterViewModel @Inject constructor() : ViewModel() {

    val isSuccessLoading2 = mutableStateOf(value = false)
    val imageErrorAuth2 = mutableStateOf(value = false)
    val progressBar2 = mutableStateOf(value = false)
    private var _filtercliente = MutableLiveData<List<Clientes>>()
    var maquinas : MutableLiveData<List<Clientes>> = _filtercliente

    fun getFilter(){
        viewModelScope.launch(Dispatchers.IO) {
            /**try {
                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getRegiones(url = Val_Constants.API_CATALOGOS_REGIONES)

                if (responseService.) {
                    delay(1500L)
                    isSuccessLoading.value = true
                    responseService.body()?.let { token ->
                        Log.d("Logging", "Response TokenDto: ${token}")
                    }
                }
            }catch (e: Exception) {
            Log.d("Logging", "Error Authentication", e)
            progressBar2.value = false
        }**/
        }
    }

}**/