package com.example.zitrocrm.network.models_dto.Filter.SalasFilter

import com.google.gson.annotations.SerializedName

data class Salas(
    @SerializedName("id") var id: Int?= null,
    @SerializedName("nombre") var nombre:String? = null,
    @SerializedName("cliente") var cliente:String? = null
)
