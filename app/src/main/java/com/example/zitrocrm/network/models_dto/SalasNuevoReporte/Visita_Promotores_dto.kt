package com.example.zitrocrm.network.models_dto.SalasNuevoReporte

import androidx.compose.runtime.Immutable

@Immutable
data class Visita_Promotores_dto(
    val id: Int,
    val title: String,
    val fecha_visita: String,
    val hora_entrada: String,
    val hora_salida: String,
    val objetivo_semanal: String
)
