package com.example.zitrocrm.network.models_dto.SalasNuevoReporte

import androidx.compose.runtime.Immutable

@Immutable
data class Lo_Mas_Jugado_Zitro_Competencia(
    val id: Int,
    val title: String,
    val provedor: Int,
    val producto:Int,
    val Zona:Int,
    val tiro_minimo:Int,
    val tiro_maximo:Int,
    val tiro_promedio:Int,
    val apuestas_promedio:Int,
    val promedio_ocupacion:Int,
    val progresivos: Int,
)
