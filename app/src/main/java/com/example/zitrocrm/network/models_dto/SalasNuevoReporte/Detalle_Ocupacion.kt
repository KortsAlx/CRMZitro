package com.example.zitrocrm.network.models_dto.SalasNuevoReporte

import androidx.compose.runtime.Immutable

@Immutable
data class Detalle_Ocupacion(
    val id: Int,
    val title: String,
    val de_horario: String,
    val a_horario: String,
    val provedor: Int
)
