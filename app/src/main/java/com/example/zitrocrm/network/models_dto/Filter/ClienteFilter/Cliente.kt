package com.example.zitrocrm.network.models_dto.Filter.ClienteFilter

import com.google.gson.annotations.SerializedName

data class Clientes(
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("nombre" ) var nombre : String? = null
)
