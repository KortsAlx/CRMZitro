package com.example.zitrocrm.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStorePreferenceRepository(context: Context) {

    private val dataStore: DataStore<Preferences> =
        context.createDataStore(name = "DB_CRM_MOVIL")
    /**LOGIN INPUT SHARE**/
    private val userloginshare = ""
    private val userLoginpass_share = ""
    /**USER INFO LOGIN**/
    private val usuario_token = ""
    private val usuario_user = ""
    private val usuario_userId = 0
    private val usuario_numberEmpleado = 0
    private val usuario_name = ""
    private val usuario_lastname = ""
    private val usuario_pass = ""
    private val usuario_area = ""
    private val usuario_statusId = 0
    private val usuario_email = ""
    private val usuario_departament = ""
    private val usuario_language = 0
    private val usuario_phone = 0
    private val usuario_comRegion = 0
    /****/
    companion object {
        /**LOGIN SHARE**/
        val PREF_LOGIN_USER = preferencesKey<String>("login_user_share")
        val PREF_LOGIN_PASS = preferencesKey<String>("login_pass_share")
        /**USER INFO LOGIN**/
        val PREF_USER =         preferencesKey<String>("user")
        val PREF_USERID =       preferencesKey<Int>("user_id")
        val PREF_NUM_EMPLEADO = preferencesKey<Int>("num_empleado")
        val PREF_NAME =         preferencesKey<String>("name_user")
        val PREF_LASTNAME =     preferencesKey<String>("last_name")
        val PREF_PASS =         preferencesKey<String>("pass_user")
        val PREF_AREA =         preferencesKey<String>("area_user")
        val PREF_STATUS_ID =    preferencesKey<Int>("status_idfk")
        val PREF_EMAIL =        preferencesKey<String>("email_user")
        val PREF_DEPARTAMENT =  preferencesKey<String>("departament_user")
        val PREF_LANGUAGE =     preferencesKey<Int>("lenguage_user")
        val PREF_PHONE =        preferencesKey<Int>("phone_user")
        val PREF_COM_REGION =   preferencesKey<Int>("com_region_use")
        val PREF_TOKEN =        preferencesKey<String>("token")
        /****/
        private var INSTANCE: DataStorePreferenceRepository? = null
        fun getInstance(context: Context): DataStorePreferenceRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }
                val instance = DataStorePreferenceRepository(context)
                INSTANCE = instance
                instance
            }
        }
    }
    //setValue
    suspend fun setUserInfo(/**Login share**/
                            token : String?,
                            userlogin : String?,
                            userpasslogin : String?,
                            user : String?,userID : Int?,name : String?,
                            lastName : String?,pass : String?, area : String?,
                            statusid : Int?, email : String?, departament : String?,
                            language : Int?, phone : Int?, num_empleado : Int?,
                            com_region : Int?) {
        dataStore.edit { preferences ->
            /**login share**/
            preferences[PREF_LOGIN_USER] = userlogin!!
            preferences[PREF_LOGIN_PASS] = userpasslogin!!
            preferences[PREF_USERID] = userID!!
            preferences[PREF_USER] = user!!
            preferences[PREF_NAME] = name!!
            preferences[PREF_LASTNAME] = lastName!!
            preferences[PREF_PASS] = pass!!
            preferences[PREF_AREA] = area!!
            preferences[PREF_STATUS_ID] = statusid!!
            preferences[PREF_EMAIL] = email!!
            preferences[PREF_DEPARTAMENT] = departament!!
            preferences[PREF_LANGUAGE] = language!!
            preferences[PREF_PHONE] = phone!!
            preferences[PREF_NUM_EMPLEADO] = num_empleado!!
            preferences[PREF_COM_REGION] = com_region!!
            preferences[PREF_TOKEN] = token!!
        }
    }
    //getValue
    val getUserLogin: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_LOGIN_USER] ?: userloginshare
        }
    val getPassLogin: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_LOGIN_PASS] ?: userLoginpass_share
        }
    val getUserId: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PREF_USERID] ?: usuario_userId
        }
    val getUser: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_USER] ?: usuario_user
        }
    val getName: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_NAME] ?: usuario_name
        }
    val getLastName: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_LASTNAME] ?: usuario_lastname
        }
    val getPassResp: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_PASS] ?: usuario_pass
        }
    val getArea: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_AREA] ?: usuario_area
        }
    val getStatusIdfk: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PREF_STATUS_ID] ?: usuario_statusId
        }
    val getEmail: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_EMAIL] ?: usuario_email
        }
    val getDepartament: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_DEPARTAMENT] ?: usuario_departament
        }
    val getLanguage: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PREF_LANGUAGE] ?: usuario_language
        }
    val getPhone: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PREF_PHONE] ?: usuario_phone
        }
    val getNumEmpleado: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PREF_NUM_EMPLEADO] ?: usuario_numberEmpleado
        }
    val getComRegion: Flow<Int> = dataStore.data
        .map { preferences ->
            preferences[PREF_COM_REGION] ?: usuario_comRegion
        }
    val getToken: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PREF_TOKEN] ?: usuario_token
        }
}
/*
class DataStoreViewModelFactory(private val dataStorePreferenceRepository: DataStorePreferenceRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataStoreViewModel::class.java)) {
            return DataStoreViewModel(dataStorePreferenceRepository) as T
        }
        throw IllegalStateException()
    }
}*/