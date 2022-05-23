package com.example.zitrocrm.network.models_dto.SalasNuevoReporte

import androidx.compose.runtime.Immutable

@Immutable
data class AcumuladosBingo(
    val id: Int,
    val title: String,
    val provedor:Int,
    val inicio: Int,
    val fin:Int,
    val evento: String,
    val hora_fin:String,
    val hora_inicio:String,
    val premio:Int
)
