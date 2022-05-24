package com.example.zitrocrm.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.zitrocrm.network.models_dto.Login.UsuarioDto

class SharedPrefence(val ctt : Context?) {
    
    private val PREFSH = "CrmZitro"
    val sharedPref : SharedPreferences = ctt!!.getSharedPreferences(PREFSH, Context.MODE_PRIVATE)

    val PREF_LOGIN_USER = "login_user_share"
    val PREF_LOGIN_PASS = "login_pass_share"
    /**USER INFO LOGIN**/
    val PREF_USER =         "user"
    val PREF_USERID =       "user_id"
    val PREF_NUM_EMPLEADO = "num_empleado"
    val PREF_NAME =         "name_user"
    val PREF_LASTNAME =     "last_name"
    val PREF_PASS =         "pass_user"
    val PREF_AREA =         "area_user"
    val PREF_STATUS_ID =    "status_idfk"
    val PREF_EMAIL =        "email_user"
    val PREF_DEPARTAMENT =  "departament_user"
    val PREF_LANGUAGE =     "lenguage_user"
    val PREF_PHONE =        "phone_user"
    val PREF_COM_REGION =   "com_region_use"
    val PREF_TOKEN =        "token"

    fun saveUser(user: String, pass: String,value : UsuarioDto, token : String){
        val editor : SharedPreferences.Editor = sharedPref.edit()
        editor.putString(PREF_LOGIN_USER, user)
        editor.putString(PREF_LOGIN_PASS, pass)
        editor.putString(PREF_USER, value.user)
        editor.putInt(PREF_USERID, value.userId!!.toInt())
        editor.putInt(PREF_NUM_EMPLEADO, value.numberEmpleado!!.toInt())
        editor.putString(PREF_NAME, value.name)
        editor.putString(PREF_LASTNAME, value.lastName)
        editor.putString(PREF_PASS, value.pass)
        editor.putString(PREF_AREA, value.area)
        editor.putInt(PREF_STATUS_ID, value.statuId!!.toInt())
        editor.putString(PREF_EMAIL, value.email)
        editor.putString(PREF_DEPARTAMENT, value.departament)
        //editor.putInt(PREF_LANGUAGE, value.language!!.toInt())
        //editor.putInt(PREF_PHONE, value.phone!!.toInt())
        //editor.putInt(PREF_COM_REGION, value.comRegion!!.toInt())
        editor.putString(PREF_TOKEN, token)
        editor.commit()

    }

    fun clearSharedPreference(){
        val editor : SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.commit()
    }

    fun getToken(): String?{ return sharedPref.getString(PREF_TOKEN, null)}

    fun getName() : String?{ return sharedPref.getString(PREF_NAME, null)}

    fun getLastName() : String?{ return sharedPref.getString(PREF_LASTNAME, null)}
}