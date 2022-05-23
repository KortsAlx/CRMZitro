package com.example.zitrocrm.network.models_dto.Login

import com.google.gson.annotations.SerializedName

data class LoginrespDto (
    @SerializedName("ok") val ok:Boolean,
    @SerializedName("usuario") val usuario: UsuarioDto,
    @SerializedName("token") val token: Object
)