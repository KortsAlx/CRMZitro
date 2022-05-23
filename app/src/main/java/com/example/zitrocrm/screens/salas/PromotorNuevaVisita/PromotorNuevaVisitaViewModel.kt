package com.example.zitrocrm.screens.salas.PromotorNuevaVisita

import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zitrocrm.network.models_dto.SalasNuevoReporte.SampleData
import com.example.zitrocrm.network.models_dto.SalasNuevoReporte.Visita_Promotores_dto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromotorNuevaVisitaViewModel @Inject constructor(

) : ViewModel() {
    /**INFO USER**/
    val token = ""
    val usuarioid = ""
    val salaid = ""
    /**VISITA PROMOTORES**/
    var fecha_visita =  mutableStateOf("Seleccionar Fecha")
    var hora_entrada_visita =  mutableStateOf("Seleccionar Hora")
    var hora_salida_visita = mutableStateOf("Seleccionar Hora")
    val objetivo_semanal =  mutableStateOf("")
    /**DETALLE DE OCUPACION**/
    var hora_ocupacion_de = mutableStateOf("Seleccionar Hora")
    var hora_ocupacion_a = mutableStateOf("Seleccionar Hora")
    val provedor_detalle_ocupacion = mutableStateOf("")
    /**OBJETIVO DE LA VISITA**/
    var objetivo_visita_obtetivo = mutableStateOf("")
    var como_logras_el_objetivo = mutableStateOf("")
    var se_logro_objetivo = mutableStateOf(0)
    var porque_objetivo = mutableStateOf("")
    /**ACUMULADOS BINGO**/
    var statecheckBingo = mutableStateOf(false)
    var provedor_acumulados = mutableStateOf("")
    var inicio = mutableStateOf("")
    var fin = mutableStateOf("")
    var evento = mutableStateOf("")
    var hora_inicio = mutableStateOf("Seleccionar Hora Inicio")
    var hora_fin = mutableStateOf("Seleccionar Hora Fin")
    var premio = mutableStateOf("")
    /**LO MAS JUGADO ZITRO Y COMPETENCIA**/
    var provedor_mas_jugado = mutableStateOf("")
    var producto_mas_jugado = mutableStateOf("")
    var fumar = mutableStateOf(0)
    var no_fumar = mutableStateOf(0)
    var tiro_minimo =  mutableStateOf("")
    var tiro_maximo =  mutableStateOf("")
    var tiro_promedio =  mutableStateOf("")
    var apuestas_promedio =  mutableStateOf("")
    var promedio_ocupacion =  mutableStateOf("")
    var progresivos_sap =  mutableStateOf(0)
    var progresivos_lap =  mutableStateOf(0)
    /**COMENTARIOS GENERALES JUGADORES**/
    var calificacion_comentarios =  mutableStateOf(0)
    var juegos_comentarios =  mutableStateOf("")
    var perfil_comentarios =  mutableStateOf("")
    var procedencia_comentarios =  mutableStateOf("")
    var ingresos_comentarios =  mutableStateOf("")
    var comentarios_jugadores =  mutableStateOf("")
    /**COMENTARIOS SONIDOS NUESTRAS MAQUINAS, ZITRO COMPETENCIA**/
    var calificacion_sonido =  mutableStateOf(0)
    var provedor_sonido_comentarios =  mutableStateOf("")
    var observaciones_sonido =  mutableStateOf("")
    /**OBSERVACIONES COMPETENCIA**/
    var calificacion_competencia =   mutableStateOf(0)
    var provedor_competencia =  mutableStateOf("")
    var observaciones_competencia =  mutableStateOf("")
    var propuestas_competencia =  mutableStateOf("")
    var conclucion_competencia =  mutableStateOf("")
    var observaciones_generales_competencia =  mutableStateOf("")
    /**FOLIOS TECNICOS**/
    var folio_tecnico =   mutableStateOf(0)
    var fecha_apertura_tecnico =  mutableStateOf("")
    var estatus_tecnico =  mutableStateOf("")
    var detalles_tecnicos =  mutableStateOf("")


    private val _cardsVisita = MutableStateFlow(listOf<Visita_Promotores_dto>())
    val cardsVisita: StateFlow<List<Visita_Promotores_dto>> get() = _cardsVisita

    private val _cards = MutableStateFlow(listOf<SampleData>())
    val cards: StateFlow<List<SampleData>> get() = _cards
    private val _cards2 = MutableStateFlow(listOf<SampleData>())
    val cards2: StateFlow<List<SampleData>> get() = _cards2
    private val _cards3 = MutableStateFlow(listOf<SampleData>())
    val cards3: StateFlow<List<SampleData>> get() = _cards3
    private val _cards4 = MutableStateFlow(listOf<SampleData>())
    val cards4: StateFlow<List<SampleData>> get() = _cards4
    private val _cards5 = MutableStateFlow(listOf<SampleData>())
    val cards5: StateFlow<List<SampleData>> get() = _cards5
    private val _cards6 = MutableStateFlow(listOf<SampleData>())
    val cards6: StateFlow<List<SampleData>> get() = _cards6
    private val _cards7 = MutableStateFlow(listOf<SampleData>())
    val cards7: StateFlow<List<SampleData>> get() = _cards7
    private val _cards8 = MutableStateFlow(listOf<SampleData>())
    val cards8: StateFlow<List<SampleData>> get() = _cards8
    private val _cards9 = MutableStateFlow(listOf<SampleData>())
    val cards9: StateFlow<List<SampleData>> get() = _cards9

    private val _expandedCardList = MutableStateFlow(listOf<Int>())
    val expandedCardList: StateFlow<List<Int>> get() = _expandedCardList

    init {
        getSampleData()
    }

    private fun getSampleData() {
        viewModelScope.launch(Dispatchers.Default) {
            val VisitaPromotoresListSpand = arrayListOf<Visita_Promotores_dto>()
            val sampleList = arrayListOf<SampleData>()
            val sampleList2 = arrayListOf<SampleData>()
            val sampleList3 = arrayListOf<SampleData>()
            val sampleList4 = arrayListOf<SampleData>()
            val sampleList5 = arrayListOf<SampleData>()
            val sampleList6 = arrayListOf<SampleData>()
            val sampleList7 = arrayListOf<SampleData>()
            val sampleList8 = arrayListOf<SampleData>()
            val sampleList9 = arrayListOf<SampleData>()

            VisitaPromotoresListSpand += Visita_Promotores_dto(
                id =  1,
                title = "Visita Promotores",
                fecha_visita = "",
                hora_entrada = "",
                hora_salida = "",
                objetivo_semanal = "",
            )
            _cardsVisita.emit(VisitaPromotoresListSpand)

            sampleList += SampleData(
                id =  1,
                title = "Visita Promotores",
            )
            _cards.emit(sampleList)

            sampleList2 += SampleData(
                id =  2,
                title = "Detalle Ocupación"
            )
            _cards2.emit(sampleList2)

            sampleList3 += SampleData(
                id =  3,
                title = "Objetivo de la Visita"
            )
            _cards3.emit(sampleList3)

            sampleList4 += SampleData(
                id =  4,
                title = "Acumulados Bingo"
            )
            _cards4.emit(sampleList4)

            sampleList5 += SampleData(
                id =  5,
                title = "Lo más jugado Zitro y competencia"
            )
            _cards5.emit(sampleList5)

            sampleList6 += SampleData(
                id =  6,
                title = "Comentarios Generales Jugadores"
            )
            _cards6.emit(sampleList6)

            sampleList7 += SampleData(
                id =  7,
                title = "Comentarios Sonido Nuestras Máquinas y Proveedores Cercanos"
            )
            _cards7.emit(sampleList7)

            sampleList8 += SampleData(
                id =  8,
                title = "Observaciones Competencia"
            )
            _cards8.emit(sampleList8)

            sampleList9 += SampleData(
                id =  9,
                title = "Folios Técnicos"
            )
            _cards9.emit(sampleList9)
        }
    }

    fun cardArrowClick(cardId: Int) {
        _expandedCardList.value = _expandedCardList.value.toMutableList().also { list ->
            if (list.contains(cardId)) {
                list.remove(cardId)
            } else {
                list.add(cardId)
            }
        }
    }

}