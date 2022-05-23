package com.example.zitrocrm.network.models_dto.SalasNuevoReporte

import androidx.compose.runtime.Immutable

@Immutable
data class Objetivo_Visita(
    val id: Int,
    val title: String,
    val objetivo: String,
    val que_haces_lograr_objetivo: String,
    val se_logro_objetivo: Boolean,
    val por_que_se_logro: String
)
