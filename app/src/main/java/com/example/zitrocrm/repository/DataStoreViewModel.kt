package com.example.zitrocrm.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataStoreViewModel(
    private val dataStorePreferenceRepository: DataStorePreferenceRepository
) : ViewModel() {

    /**VAR USER INFO**/
    var _userinput = MutableLiveData("")
    val user_input: MutableLiveData<String> = _userinput
    var _passinput = MutableLiveData("")
    val pass_input: MutableLiveData<String> = _passinput

    var _usuario_userId = MutableLiveData(0)
    val usuario_userId: MutableLiveData<Int> = _usuario_userId
    var _usuario_user = MutableLiveData("")
    val usuario_user: MutableLiveData<String> = _usuario_user
    var _usuario_name = MutableLiveData("")
    val usuario_name: MutableLiveData<String> = _usuario_name
    var _usuario_lastname = MutableLiveData("")
    val usuario_lastname: MutableLiveData<String> = _usuario_lastname
    var _usuario_pass = MutableLiveData("")
    val usuario_pass: MutableLiveData<String> = _usuario_pass
    var _usuario_area = MutableLiveData("")
    val usuario_area: MutableLiveData<String> = _usuario_area
    var _usuario_statusId = MutableLiveData(0)
    val usuario_statusId: MutableLiveData<Int> = _usuario_statusId
    var _usuario_email = MutableLiveData("")
    val usuario_email: MutableLiveData<String> = _usuario_email
    var _usuario_departament = MutableLiveData("")
    val usuario_departament: MutableLiveData<String> = _usuario_departament
    var _usuario_language = MutableLiveData(0)
    val usuario_language: MutableLiveData<Int> = _usuario_language
    var _usuario_phone = MutableLiveData(0)
    val usuario_phone: MutableLiveData<Int> = _usuario_phone
    var _usuario_numberEmpleado = MutableLiveData(0)
    val usuario_numberEmpleado: MutableLiveData<Int> = _usuario_numberEmpleado
    var _usuario_comRegion = MutableLiveData(0)
    val usuario_comRegion: MutableLiveData<Int> = _usuario_comRegion
    /**VAR TOKEN**/
    var _usuario_token = MutableLiveData("")
    val usuario_token: MutableLiveData<String> = _usuario_token


    init {
        viewModelScope.launch {
            dataStorePreferenceRepository.getUserLogin.collect {
                _userinput.value = it
            }
            dataStorePreferenceRepository.getPassLogin.collect {
                _passinput.value = it
            }
            dataStorePreferenceRepository.getUserId.collect {
                _usuario_userId.value = it
            }
            dataStorePreferenceRepository.getUser.collect {
                _usuario_user.value = it
            }
            dataStorePreferenceRepository.getName.collect {
                _usuario_name.value = it
            }
            dataStorePreferenceRepository.getLastName.collect {
                _usuario_lastname.value = it
            }
            dataStorePreferenceRepository.getPassResp.collect {
                _usuario_pass.value = it
            }
            dataStorePreferenceRepository.getArea.collect {
                _usuario_area.value = it
            }
            dataStorePreferenceRepository.getStatusIdfk.collect {
                _usuario_statusId.value = it
            }
            dataStorePreferenceRepository.getEmail.collect {
                _usuario_email.value = it
            }
            dataStorePreferenceRepository.getDepartament.collect {
                _usuario_departament.value = it
            }
            dataStorePreferenceRepository.getLanguage.collect {
                _usuario_language.value = it
            }
            dataStorePreferenceRepository.getPhone.collect {
                _usuario_phone.value = it
            }
            dataStorePreferenceRepository.getNumEmpleado.collect {
                _usuario_numberEmpleado.value = it
            }
            dataStorePreferenceRepository.getComRegion.collect {
                _usuario_comRegion.value = it
            }
            dataStorePreferenceRepository.getToken.collect {
                _usuario_token.value = it
            }
        }
    }
    suspend fun saveUserInfo( token : String?,
                              userlogin : String?,
                              userpasslogin : String?,
                              user : String?,userID : Int?,name : String?,
                              lastName : String?,pass : String?, area : String?,
                              statusid : Int?, email : String?, departament : String?,
                              language : Int?, phone : Int?, num_empleado : Int?,
                              com_region : Int?) {

      /*  dataStorePreferenceRepository.setUserInfo(
            token, userlogin, userpasslogin,
            user, userID, name, lastName,
            pass, area, statusid, email,
            departament, language, phone,
            num_empleado,                                   com_region,
        )*/
    }
}

class DataViewModelFactory(private val userDataPreferencesRepository : DataStorePreferenceRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return DataStoreViewModel(userDataPreferencesRepository) as T

    }

}



