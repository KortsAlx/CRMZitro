package com.example.zitrocrm.screens.salas

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.zitrocrm.R
import com.example.zitrocrm.network.models_dto.SalasNuevoReporte.SampleData
import com.example.zitrocrm.screens.salas.PromotorNuevaVisita.PromotorNuevaVisitaViewModel
import com.example.zitrocrm.ui.theme.blackdark
import com.example.zitrocrm.ui.theme.graydark
import com.example.zitrocrm.ui.theme.reds
import com.example.zitrocrm.utils.Val_Constants.CollapseAnimation
import com.example.zitrocrm.utils.Val_Constants.ExpandAnimation
import com.example.zitrocrm.utils.Val_Constants.FadeInAnimation
import com.example.zitrocrm.utils.Val_Constants.FadeOutAnimation
import java.util.*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PromotorNewScreen (navController: NavController, viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel){
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                modifier = Modifier.height(70.dp),
                title = {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(R.drawable.back_button),
                            contentDescription = "",
                            modifier = Modifier
                                .clickable {
                                    navController.popBackStack()
                                }
                                .align(Alignment.CenterStart)
                                .size(29.dp),
                        )
                        Image(
                            painter = painterResource(R.drawable.crm_logo),
                            contentDescription = "",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(5.dp)
                        )
                        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                            if(viewModelPromotorNuevaVisita.statecheckBingo.value==false) {
                                Text(text = "Bingo",
                                    modifier = Modifier.align(CenterVertically),
                                    style = MaterialTheme.typography.subtitle2,
                                    fontSize = 10.sp,
                                    color = Color.Green
                                )
                            }else {
                                Text(text = "Bingo",
                                    modifier = Modifier.align(CenterVertically),
                                    style = MaterialTheme.typography.subtitle2,
                                    fontSize = 10.sp,
                                    color = Color.White
                                )
                            }
                            Switch(
                                checked = viewModelPromotorNuevaVisita.statecheckBingo.value,
                                onCheckedChange = { viewModelPromotorNuevaVisita.statecheckBingo.value = it },
                                modifier = Modifier.align(CenterVertically),
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    uncheckedThumbColor = Color.White,
                                    checkedTrackColor = Color.LightGray,
                                    uncheckedTrackColor = Color.DarkGray,
                                    checkedTrackAlpha = 1.0f,
                                    uncheckedTrackAlpha = 1.0f
                                )
                            )
                            if(viewModelPromotorNuevaVisita.statecheckBingo.value==true) {
                                Text(text = "Slots",
                                    modifier = Modifier.align(CenterVertically),
                                    style = MaterialTheme.typography.subtitle2,
                                    fontSize = 10.sp,
                                    color = Color.Green
                                )
                            }else {
                                Text(text = "Slots",
                                    modifier = Modifier.align(CenterVertically),
                                    style = MaterialTheme.typography.subtitle2,
                                    fontSize = 10.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                },
                backgroundColor = reds,
            )
        }
    )
    {
        val viewModelPromotorNuevaVisita = viewModelPromotorNuevaVisita
        val cards = viewModelPromotorNuevaVisita.cards.collectAsState()
        val cards2 = viewModelPromotorNuevaVisita.cards2.collectAsState()
        val cards3 = viewModelPromotorNuevaVisita.cards3.collectAsState()
        val cards4 = viewModelPromotorNuevaVisita.cards4.collectAsState()
        val cards5 = viewModelPromotorNuevaVisita.cards5.collectAsState()
        val cards6 = viewModelPromotorNuevaVisita.cards6.collectAsState()
        val cards7 = viewModelPromotorNuevaVisita.cards7.collectAsState()
        val cards8 = viewModelPromotorNuevaVisita.cards8.collectAsState()
        val cards9 = viewModelPromotorNuevaVisita.cards9.collectAsState()
        val expandedCard = viewModelPromotorNuevaVisita.expandedCardList.collectAsState()

        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp)
                ) {
                    LazyColumn {
                        itemsIndexed(cards.value) { _, card ->
                            VisitaPromotoresCard(
                                card = card,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card.id) },
                                expanded = expandedCard.value.contains(card.id), viewModelPromotorNuevaVisita
                            )
                        }
                        itemsIndexed(cards2.value) { _, card2 ->
                            DetalleOcupacionCard(
                                card2 = card2,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card2.id) },
                                expanded = expandedCard.value.contains(card2.id),viewModelPromotorNuevaVisita
                            )
                        }
                        itemsIndexed(cards3.value) { _, card3 ->
                            ObjetivoVisitaCard(
                                card3 = card3,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card3.id) },
                                expanded = expandedCard.value.contains(card3.id),viewModelPromotorNuevaVisita
                            )
                        }
                        if(viewModelPromotorNuevaVisita.statecheckBingo.value == false) {
                            itemsIndexed(cards4.value) { _, card4 ->
                                AcumuladosBingoCard(
                                    card4 = card4,
                                    onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card4.id) },
                                    expanded = expandedCard.value.contains(card4.id),viewModelPromotorNuevaVisita
                                )
                            }
                        }
                        itemsIndexed(cards5.value) { _, card5 ->
                            JugadoZitroCompetencia(
                                card5 = card5,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card5.id) },
                                expanded = expandedCard.value.contains(card5.id),viewModelPromotorNuevaVisita
                            )
                        }
                        itemsIndexed(cards6.value) { _, card6 ->
                            ComentariosGeneralesJugadores(
                                card6 = card6,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card6.id) },
                                expanded = expandedCard.value.contains(card6.id),viewModelPromotorNuevaVisita
                            )
                        }
                        itemsIndexed(cards7.value) { _, card7 ->
                            ComentariosSonidoZitroComp(
                                card7 = card7,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card7.id) },
                                expanded = expandedCard.value.contains(card7.id),viewModelPromotorNuevaVisita
                            )
                        }
                        itemsIndexed(cards8.value) { _, card8->
                            ObservacionesCompetencia(
                                card8 = card8,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card8.id) },
                                expanded = expandedCard.value.contains(card8.id),viewModelPromotorNuevaVisita
                            )
                        }
                        itemsIndexed(cards9.value) { _, card9->
                            FoliosTecnicos(
                                card9 = card9,
                                onCardArrowClick = { viewModelPromotorNuevaVisita.cardArrowClick(card9.id) },
                                expanded = expandedCard.value.contains(card9.id),viewModelPromotorNuevaVisita
                            )
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun VisitaPromotoresCard(
    card: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    Column(
        modifier = Modifier
            .padding(bottom = 10.dp, top = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(blackdark)
            .fillMaxWidth()
            .size(80.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(R.drawable.reporte_visitas_icon),
            contentDescription = "",
            modifier = Modifier
                .padding(0.dp)
                .size(50.dp)
        )
        Text(
            text = "Nueva Visita",
            style = MaterialTheme.typography.subtitle2,
            fontSize = 16.sp
        )
    }
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }
    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
               Row(
                   modifier = Modifier.fillMaxWidth()
               ) {
                   Column(
                       modifier = Modifier
                           .weight(0.15f)
                           .align(Alignment.CenterVertically)){
                       Image(painter = painterResource(id = R.drawable.reporte_visitas_icon),
                           contentDescription ="IconList", modifier = Modifier.padding(start = 10.dp))
                   }
                   Column(
                       modifier = Modifier.weight(1f)
                   ) {
                       Text(
                           text = card.title,
                           color = Color.White,
                           textAlign = TextAlign.Center,
                           style = MaterialTheme.typography.subtitle2,
                           fontSize = 14.sp,
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(
                                   horizontal = 12.dp,
                                   vertical = 25.dp
                               )
                       )
                   }
                   Column(
                       modifier = Modifier
                           .weight(0.15f)
                           .align(CenterVertically)
                   ) {
                       CardArrow(
                           degrees = arrowRotationDegree,
                           onClick = onCardArrowClick
                       )
                   }
               }
            }
            ExpandableContent(expanded,viewModelPromotorNuevaVisita)
        }
    }
}

@Composable
fun CardArrow(
    degrees: Float,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Expandable Arrow",
                modifier = Modifier
                    .rotate(degrees)
                    .size(30.dp),
            )
        }
    )
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    /**VIEWMODEL**/
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 10.dp)) {
                    /**FECHA DE VISITA**/
                    val mContext = LocalContext.current
                    val mYear: Int
                    val mMonth: Int
                    val mDay: Int
                    val mCalendar = Calendar.getInstance()

                    val mHour = mCalendar.get(Calendar.HOUR_OF_DAY)
                    val mMinute = mCalendar.get(Calendar.HOUR_OF_DAY)
                    mYear = mCalendar.get(Calendar.YEAR)
                    mMonth = mCalendar.get(Calendar.MONTH)
                    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
                    mCalendar.time = Date()

                    val mDatePickerDialog = DatePickerDialog(
                        mContext,
                        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                            viewModelPromotorNuevaVisita.fecha_visita.value = "$mDayOfMonth/${mMonth+1}/$mYear"
                        }, mYear, mMonth, mDay
                    )

                    val mTimePickerDialogEntrada = TimePickerDialog(
                        mContext,
                        {_, mHour : Int, mMinute: Int ->
                            viewModelPromotorNuevaVisita.hora_entrada_visita.value = "$mHour"
                        }, mHour, mMinute, true
                    )

                    val mTimePickerDialogSalida = TimePickerDialog(
                        mContext,
                        {_, mHour : Int, mMinute : Int ->
                            viewModelPromotorNuevaVisita.hora_salida_visita.value = "$mHour"
                        }, mHour, mMinute, true
                    )

                    Text(
                        text = "Fecha de Visita",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )

                    Row (modifier = Modifier
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { mDatePickerDialog.show() }
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.DateRange, "Fecha")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.fecha_visita.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    /**HORARIO DE ENTRADA**/
                    Text(
                        text = "Hora de Entrada",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp)

                    Row (modifier = Modifier
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { mTimePickerDialogEntrada.show() }
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.Timer, "Hora")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.hora_entrada_visita.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    /**HORARIO DE SALIDA**/
                    Text(
                        text = "Hora de Salida",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp)

                    Row (modifier = Modifier
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { mTimePickerDialogSalida.show() }
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.Timer, "Hora")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.hora_salida_visita.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = listOf("Promocion Dragon Lamp","Promocion Bingo Link", "Promocion Energy Link", "Promocion Energy King", "Promocion Price Up","Promocion Show Time", "Promocion Big Time","Promocion a juegos especificos","Promocion islas especificas","Elaboración de layout");
                    var selectedText by remember { mutableStateOf("") }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon = if (expanded)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown
                    Column() {
                        Text(text = "Objetivo Semanal",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(vertical = 15.dp),
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 19.sp)

                        OutlinedTextField(
                            value = viewModelPromotorNuevaVisita.objetivo_semanal.value,
                            onValueChange = { selectedText },
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    textfieldSize = coordinates.size.toSize()
                                },
                            label = {Text("Objetivo Semanal")},
                            trailingIcon = {
                                Icon(icon,"contentDescription",
                                    Modifier.clickable { expanded = !expanded })
                            }
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                        ) {
                            suggestions.forEach { label ->
                                DropdownMenuItem(onClick = {
                                    viewModelPromotorNuevaVisita.objetivo_semanal.value = label
                                    expanded = false
                                }) {
                                    Text(text = label)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun DetalleOcupacionCard(
    card2: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }
    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.detalles),
                            contentDescription ="IconList", modifier = Modifier.padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = card2.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent2(expanded,viewModelPromotorNuevaVisita)
        }
    }
}
@ExperimentalAnimationApi
@Composable
fun ExpandableContent2(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }
    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 10.dp)) {
                    /**FECHA DE VISITA**/
                    Text(
                        text = "Horarios",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 19.sp
                    )
                    val mContext = LocalContext.current
                    val mCalendar = Calendar.getInstance()
                    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
                    val mMinute = mCalendar[Calendar.MINUTE]
                    mCalendar.time = Date()
                    val mTimePickerDialogEntrada = TimePickerDialog(
                        mContext,
                        {_, mHour : Int, mMinute: Int ->
                            viewModelPromotorNuevaVisita.hora_ocupacion_de.value = "$mHour"
                        }, mHour, mMinute, true
                    )
                    val mTimePickerDialogSalida = TimePickerDialog(
                        mContext,
                        {_, mHour : Int, mMinute: Int ->
                            viewModelPromotorNuevaVisita.hora_ocupacion_a.value = "$mHour"
                        }, mHour, mMinute, true
                    )
                    /**HORARIO DE ENTRADA**/
                    Text(
                        text = "DE",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2)
                    Row (modifier = Modifier
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { mTimePickerDialogEntrada.show() }
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.Timer, "Hora")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.hora_ocupacion_de.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    /**HORARIO DE SALIDA**/
                    Text(
                        text = "A",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2
                    )
                    Row (modifier = Modifier
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { mTimePickerDialogSalida.show() }
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.Timer, "Hora")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.hora_ocupacion_a.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = listOf("ZITRO","AGS", "AMBRA GAMING", "BETSTONE BINGO", "BLUEBERI","DEGESTEC", "EIBE","FBM","IGT LUDICUS","INTERVISION","JCB GAMING","JESTRONIC","KONAMI BINGO","LATINA WORLD GAMING","LUDICUS/ZEST GAMMING","METRONIA / BEMEX","PACHINKO","R. FRANCO","RCT","SABIA");
                    var selectedText by remember { mutableStateOf("") }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon = if (expanded)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown
                    Column() {
                        Text(text = "Proveedor",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(vertical = 10.dp),
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 19.sp)

                        OutlinedTextField(
                            value = viewModelPromotorNuevaVisita.provedor_detalle_ocupacion.value,
                            onValueChange = { selectedText },
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    textfieldSize = coordinates.size.toSize()
                                },
                            label = {Text("Proveedor")},
                            trailingIcon = {
                                Icon(icon,"contentDescription",
                                    Modifier.clickable { expanded = !expanded })
                            }
                        )
                        Spacer(Modifier.height(10.dp))
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                        ) {
                            suggestions.forEach { label ->
                                DropdownMenuItem(onClick = {
                                    viewModelPromotorNuevaVisita.provedor_detalle_ocupacion.value = label
                                    expanded = false
                                }) {
                                    Text(text = label)
                                }
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            elevation = ButtonDefaults.elevation(defaultElevation = 5.dp),
                            shape = RoundedCornerShape(10),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.reds)
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Filled.CheckCircle,
                                contentDescription = "Precio Inicio",
                            )
                        }
                    }
                }
            }
        }
    }
}

/**OBJETIVO DE LA VISITA EXPAND LIST**/

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ObjetivoVisitaCard(
    card3: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }
    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.lista_de_verificacion),
                            contentDescription ="IconList",
                            modifier = Modifier
                                .padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = card3.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent3(expanded,viewModelPromotorNuevaVisita)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent3(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }
    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
             ) {

                    Text(text = "Objetivo",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 10.dp),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 19.sp)
                    var seLogroObjetivo = remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.objetivo_visita_obtetivo.value,
                        onValueChange = { viewModelPromotorNuevaVisita.objetivo_visita_obtetivo.value = it },
                        label = { Text("Objetivo") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Filled.TextFormat,
                                    contentDescription = "Botón para elegir fecha"
                                )
                            }
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.como_logras_el_objetivo.value,
                        onValueChange = { viewModelPromotorNuevaVisita.como_logras_el_objetivo.value = it },
                        label = { Text("¿Qué haces para lograr el Objetivo?") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Filled.TextFormat,
                                    contentDescription = "Botón para elegir fecha"
                                )
                            }
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
                        Text(text = "        - ",
                            modifier = Modifier
                                .padding(vertical = 10.dp),
                            style = MaterialTheme.typography.subtitle2,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp)
                        Text(text = "¿Se logro el objetivo?",
                            modifier = Modifier
                                .padding(vertical = 10.dp),
                            style = MaterialTheme.typography.subtitle2,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp)
                        Spacer(Modifier.width(10.dp))
                        Checkbox(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .align(Alignment.CenterVertically),
                            checked = seLogroObjetivo.value,
                            onCheckedChange = {seLogroObjetivo.value = it
                            if(seLogroObjetivo.value==true){
                                viewModelPromotorNuevaVisita.se_logro_objetivo.value=1
                            }else if(seLogroObjetivo.value==false) {
                                viewModelPromotorNuevaVisita.se_logro_objetivo.value=0
                            }
                            }
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.porque_objetivo.value,
                        onValueChange = { viewModelPromotorNuevaVisita.porque_objetivo.value = it },
                        label = { Text("¿Por que?") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Filled.QuestionAnswer,
                                    contentDescription = "Botón para elegir fecha"
                                )
                            }
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}
@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun AcumuladosBingoCard(
    card4: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel

) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }

    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.bingo),
                            contentDescription ="IconList",
                            modifier = Modifier.padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = card4.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent4(expanded, viewModelPromotorNuevaVisita)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent4(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {

                    val mCalendar = Calendar.getInstance()
                    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
                    val mMinute = mCalendar[Calendar.MINUTE]
                    val mContext = LocalContext.current
                    val mTimePickerDialogInicio = TimePickerDialog(
                        mContext,
                        {_, mHour : Int, mMinute: Int ->
                            viewModelPromotorNuevaVisita.hora_inicio.value = "$mHour"
                        }, mHour, mMinute, true
                    )
                    val mTimePickerDialogFin = TimePickerDialog(
                        mContext,
                        {_, mHour : Int, mMinute: Int ->
                            viewModelPromotorNuevaVisita.hora_fin.value = "$mHour"
                        }, mHour, mMinute, true
                    )
                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = listOf("ZITRO","AGS", "AMBRA GAMING", "BETSTONE BINGO", "BLUEBERI","DEGESTEC", "EIBE","FBM","IGT LUDICUS","INTERVISION","JCB GAMING","JESTRONIC","KONAMI BINGO","LATINA WORLD GAMING","LUDICUS/ZEST GAMMING","METRONIA / BEMEX","PACHINKO","R. FRANCO","RCT","SABIA");
                    var selectedText by remember { mutableStateOf("") }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon =
                        if (expanded)
                        Icons.Filled.KeyboardArrowUp
                        else
                        Icons.Filled.KeyboardArrowDown
                    var sum by remember { mutableStateOf(0)}
                    val onCalculate = {
                        sum = viewModelPromotorNuevaVisita.inicio.value.toInt() - viewModelPromotorNuevaVisita.fin.value.toInt()
                    }
                    val focusManager = LocalFocusManager.current
                    Text(text = "Proveedores",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 10.dp),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 19.sp)
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.provedor_acumulados.value,
                        onValueChange = { selectedText },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Seleccionar Provedor")},
                        trailingIcon = {
                            Icon(icon,"contentDescription",
                                Modifier.clickable { expanded = !expanded })
                        }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                    ) {
                        suggestions.forEach { label ->
                            DropdownMenuItem(onClick = {
                                viewModelPromotorNuevaVisita.provedor_acumulados.value = label
                                expanded = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxWidth()){
                        OutlinedTextField(
                            value = viewModelPromotorNuevaVisita.inicio.value,
                            onValueChange = { viewModelPromotorNuevaVisita.inicio.value = it },
                            label = { Text("Inicio") },
                            modifier = Modifier.fillMaxWidth(.5f),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Right) }
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.MonetizationOn,
                                    contentDescription = "Precio Inicio"
                                )
                            }
                        )
                        Spacer(Modifier.width(5.dp))
                        OutlinedTextField(
                            value = viewModelPromotorNuevaVisita.fin.value,
                            onValueChange = { viewModelPromotorNuevaVisita.fin.value = it},
                            label = { Text("Fin") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Down) },
                                onDone = {onCalculate}
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.MonetizationOn,
                                    contentDescription = "Precio Inicio"
                                )
                            }
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Diferencia",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.MonetizationOn, "Diferencia")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${sum}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.evento.value,
                        onValueChange = { viewModelPromotorNuevaVisita.evento.value = it },
                        label = { Text("Evento") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Event,
                                contentDescription = "Precio Inicio"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    /**HORARIO**/
                    Text(
                        text = "Hora",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp)
                    Spacer(Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { mTimePickerDialogInicio.show() }
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.Timer, "Hora Inicio")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.hora_inicio.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Hora",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp)
                    Spacer(Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { mTimePickerDialogFin.show() }
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.Timer, "Hora Fin")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.hora_fin.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.premio.value,
                        onValueChange = {  viewModelPromotorNuevaVisita.premio.value = it  },
                        label = { Text("Premio") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Right) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.MonetizationOn,
                                contentDescription = "Precio Inicio"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        elevation = ButtonDefaults.elevation(defaultElevation = 5.dp),
                        shape = RoundedCornerShape(10),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.reds)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = "Precio Inicio",
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun JugadoZitroCompetencia(
    card5: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardPaddingHorizontal by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "paddingTransition") {
        20.dp
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }

    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.nav_maquinas_icon),
                            contentDescription ="IconList",
                            modifier = Modifier.padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = card5.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent5(expanded, viewModelPromotorNuevaVisita)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent5(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita : PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    var expanded by remember { mutableStateOf(false) }
                    var expanded2 by remember { mutableStateOf(false) }
                    val suggestions2 = listOf("Fire Bingo","La Calaca Bingo", "Bingo Dream", "Jerry Bingo", "Multispace Bingo Cleaners","El Ultimo Bingo en Paris", "Tacomania","Spin Bingo","Bingo Story","EL BINGO Y LA BESTIA","80s Bingo","Tropical Bingo","ZITRO BEETLE BINGO","Revolution","Hot Dice Multi ll","HOT DICE","TRIPLE BONUS FENIX","TRIPLE BONUS","RCT","ULTIMO BINGO EN PARIS");
                    val suggestions = listOf("ZITRO","AGS", "AMBRA GAMING", "BETSTONE BINGO", "BLUEBERI","DEGESTEC", "EIBE","FBM","IGT LUDICUS","INTERVISION","JCB GAMING","JESTRONIC","KONAMI BINGO","LATINA WORLD GAMING","LUDICUS/ZEST GAMMING","METRONIA / BEMEX","PACHINKO","R. FRANCO","RCT","SABIA");
                    var selectedText by remember { mutableStateOf("") }
                    var selectedText2 by remember { mutableStateOf("") }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon =
                        if (expanded)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.KeyboardArrowDown
                    var tirominimo by remember { mutableStateOf("")}
                    var tiromaximo by remember { mutableStateOf("")}
                    val focusManager = LocalFocusManager.current
                    var tiropromedio by remember { mutableStateOf("")}
                    var apuestaspromedio by remember { mutableStateOf("")}
                    var promedioocupacion by remember { mutableStateOf("")}
                    var sap = remember { mutableStateOf(false) }
                    var lap = remember { mutableStateOf(false) }
                    var fumar = remember { mutableStateOf(false) }
                    var nofumar = remember { mutableStateOf(false) }

                    /****/
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.provedor_mas_jugado.value,
                        onValueChange = { selectedText },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Seleccionar Provedor")},
                        trailingIcon = {
                            Icon(icon,"contentDescription",
                                Modifier.clickable { expanded = !expanded })
                        }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                    ) {
                        suggestions.forEach { label ->
                            DropdownMenuItem(onClick = {
                                viewModelPromotorNuevaVisita.provedor_mas_jugado.value = label
                                expanded = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.producto_mas_jugado.value,
                        onValueChange = { selectedText2 },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Producto")},
                        trailingIcon = {
                            Icon(icon,"contentDescription",
                                Modifier.clickable { expanded2 = !expanded2 })
                        }
                    )
                    DropdownMenu(
                        expanded = expanded2,
                        onDismissRequest = { expanded2 = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                    ) {
                        suggestions2.forEach { label ->
                            DropdownMenuItem(onClick = {
                                viewModelPromotorNuevaVisita.producto_mas_jugado.value = label
                                expanded2 = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Zona",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth(.5f)
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.SmokingRooms, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "FUMAR",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = fumar.value,
                                onCheckedChange = { fumar.value = it
                                if(fumar.value==true){
                                    viewModelPromotorNuevaVisita.fumar.value = 1
                                }}
                            )
                        }
                        Spacer(Modifier.width(5.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth()
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.SmokeFree, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "NO FUMAR",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = nofumar.value,
                                onCheckedChange = { nofumar.value = it
                                if(nofumar.value==true){
                                    viewModelPromotorNuevaVisita.no_fumar.value = 2
                                }
                                }
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxWidth()){
                        OutlinedTextField(
                            value = viewModelPromotorNuevaVisita.tiro_minimo.value,
                            onValueChange = { viewModelPromotorNuevaVisita.tiro_minimo.value = it },
                            label = { Text("Tiro Minimo") },
                            modifier = Modifier.fillMaxWidth(.5f),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Right) }
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.MonetizationOn,
                                    contentDescription = "Precio Inicio"
                                )
                            }
                        )
                        Spacer(Modifier.width(5.dp))
                        OutlinedTextField(
                            value = viewModelPromotorNuevaVisita.tiro_maximo.value,
                            onValueChange = { viewModelPromotorNuevaVisita.tiro_maximo.value = it },
                            label = { Text("Tiro Maximo") },
                            modifier = Modifier.fillMaxWidth(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Down) }
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.MonetizationOn,
                                    contentDescription = "Precio Inicio"
                                )
                            }
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.tiro_promedio.value,
                        onValueChange = { viewModelPromotorNuevaVisita.tiro_promedio.value = it },
                        label = { Text("Tiro Promedio") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.MonetizationOn,
                                contentDescription = "Tiro"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.apuestas_promedio.value,
                        onValueChange = { viewModelPromotorNuevaVisita.apuestas_promedio.value = it },
                        label = { Text("Apuestas Promedio") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.ConfirmationNumber,
                                contentDescription = "Precio Inicio"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.promedio_ocupacion.value,
                        onValueChange = { viewModelPromotorNuevaVisita.promedio_ocupacion.value = it },
                        label = { Text("Promedio de Ocupación") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.MonetizationOn,
                                contentDescription = "Precio Inicio"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Progresivos (SAP, LAP)",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth(.5f)
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.Money, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "SAP",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = sap.value,
                                onCheckedChange = { sap.value = it
                                    if(sap.value==true){
                                    viewModelPromotorNuevaVisita.progresivos_sap.value = 1
                                    }
                                }
                            )
                        }
                        Spacer(Modifier.width(5.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth()
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.Money, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "LAP",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = lap.value,
                                onCheckedChange = { lap.value = it
                                    if(lap.value==true){
                                        viewModelPromotorNuevaVisita.progresivos_lap.value = 2
                                    }
                                }
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        elevation = ButtonDefaults.elevation(defaultElevation = 5.dp),
                        shape = RoundedCornerShape(10),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.reds)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = "Precio Inicio",
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ComentariosGeneralesJugadores(
    card6: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardPaddingHorizontal by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "paddingTransition") {
        20.dp
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }

    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.comentarios),
                            contentDescription ="IconList",
                            modifier = Modifier.padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = card6.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent6(expanded, viewModelPromotorNuevaVisita)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent6(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita : PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }
    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    var juegosexpanded by remember { mutableStateOf(false) }
                    var perfilexpanded by remember { mutableStateOf(false) }
                    val juegoslist = listOf("Fire Bingo","La Calaca Bingo", "Bingo Dream", "Jerry Bingo", "Multispace Bingo Cleaners","El Ultimo Bingo en Paris", "Tacomania","Spin Bingo","Bingo Story","EL BINGO Y LA BESTIA","80s Bingo","Tropical Bingo","ZITRO BEETLE BINGO","Revolution","Hot Dice Multi ll","HOT DICE","TRIPLE BONUS FENIX","TRIPLE BONUS","RCT","ULTIMO BINGO EN PARIS");
                    val perfil = listOf("Alta","Media","Baja");
                    var perfilselectedText by remember { mutableStateOf("") }
                    var juegosselectedText by remember { mutableStateOf("") }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon =
                        if (expanded)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.KeyboardArrowDown
                    val focusManager = LocalFocusManager.current
                    var ingresos by remember { mutableStateOf("")}
                    var procedencia by remember { mutableStateOf("")}
                    var comentarios by remember { mutableStateOf("")}
                    var positivo = remember { mutableStateOf(false) }
                    var negativo = remember { mutableStateOf(false) }
                    Text(text = "Calificacion",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth(.5f)
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.CheckCircle, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "Positivo",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = positivo.value,
                                onCheckedChange = {
                                    positivo.value = it
                                    if (positivo.value == true) {
                                        negativo.value=false
                                        viewModelPromotorNuevaVisita.calificacion_comentarios.value = 1
                                    }
                                }
                            )
                        }
                        Spacer(Modifier.width(5.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth()
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.CheckCircleOutline, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "Negativo",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = negativo.value,
                                onCheckedChange = {
                                    negativo.value = it
                                    if (negativo.value == true) {
                                        positivo.value=false
                                        viewModelPromotorNuevaVisita.calificacion_comentarios.value = 0
                                    }
                                }
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.juegos_comentarios.value,
                        onValueChange = { juegosselectedText },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Juegos")},
                        trailingIcon = {
                            Icon(icon,"contentDescription",
                                Modifier.clickable { juegosexpanded = !juegosexpanded })
                        }
                    )
                    DropdownMenu(
                        expanded = juegosexpanded,
                        onDismissRequest = { juegosexpanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                    ) {
                        juegoslist.forEach { label ->
                            DropdownMenuItem(onClick = {
                                viewModelPromotorNuevaVisita.juegos_comentarios.value = label
                                juegosexpanded = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.perfil_comentarios.value,
                        onValueChange = { perfilselectedText },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Perfil")},
                        trailingIcon = {
                            Icon(icon,"contentDescription",
                                Modifier.clickable { perfilexpanded = !perfilexpanded })
                        }
                    )
                    DropdownMenu(
                        expanded = perfilexpanded,
                        onDismissRequest = { perfilexpanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                    ) {
                        perfil.forEach { label ->
                            DropdownMenuItem(onClick = {
                                viewModelPromotorNuevaVisita.perfil_comentarios.value = label
                                perfilexpanded = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.procedencia_comentarios.value,
                        onValueChange = {  viewModelPromotorNuevaVisita.procedencia_comentarios.value = it },
                        label = { Text("Procedencia") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.FilePresent,
                                contentDescription = "Procedencia"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value =  viewModelPromotorNuevaVisita.ingresos_comentarios.value,
                        onValueChange = {  viewModelPromotorNuevaVisita.ingresos_comentarios.value = it },
                        label = { Text("Ingresos") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.MonetizationOn,
                                contentDescription = "Tiro"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value =  viewModelPromotorNuevaVisita.comentarios_jugadores.value,
                        onValueChange = { viewModelPromotorNuevaVisita.comentarios_jugadores.value = it },
                        label = { Text("Comentarios") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Comment,
                                contentDescription = "Comentarios"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        elevation = ButtonDefaults.elevation(defaultElevation = 5.dp),
                        shape = RoundedCornerShape(10),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.reds)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = "Precio Inicio",
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ComentariosSonidoZitroComp(
    card7: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }

    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.comentarios__1_),
                            contentDescription ="IconList",
                            modifier = Modifier.padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = card7.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent7(expanded, viewModelPromotorNuevaVisita)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent7(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita : PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = listOf("ZITRO","AGS", "AMBRA GAMING", "BETSTONE BINGO", "BLUEBERI","DEGESTEC", "EIBE","FBM","IGT LUDICUS","INTERVISION","JCB GAMING","JESTRONIC","KONAMI BINGO","LATINA WORLD GAMING","LUDICUS/ZEST GAMMING","METRONIA / BEMEX","PACHINKO","R. FRANCO","RCT","SABIA");
                    var selectedText by remember { mutableStateOf("") }
                    var observaciones by remember { mutableStateOf("") }
                    var positivo by remember { mutableStateOf(false) }
                    var negativo by remember { mutableStateOf(false) }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon =
                        if (expanded)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.KeyboardArrowDown
                    val focusManager = LocalFocusManager.current
                    /****/
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Calificacion",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth(.5f)
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.CheckCircle, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "Positivo",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(CenterVertically),
                                checked = positivo,
                                onCheckedChange = {
                                    positivo = it
                                    if (positivo==true) {
                                        viewModelPromotorNuevaVisita.calificacion_sonido.value = 1
                                        negativo=false
                                    }
                                }
                            )
                        }
                        Spacer(Modifier.width(5.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth()
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.CheckCircleOutline, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "Negativo",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = negativo,
                                onCheckedChange = {
                                    negativo = it
                                    if (negativo == true) {
                                        viewModelPromotorNuevaVisita.calificacion_sonido.value = 0
                                        positivo = false
                                    }
                                }
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.provedor_sonido_comentarios.value,
                        onValueChange = { selectedText },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Seleccionar Provedor")},
                        trailingIcon = {
                            Icon(icon,"contentDescription",
                                Modifier.clickable { expanded = !expanded })
                        }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                    ) {
                        suggestions.forEach { label ->
                            DropdownMenuItem(onClick = {
                                viewModelPromotorNuevaVisita.provedor_sonido_comentarios.value = label
                                expanded = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.observaciones_sonido.value,
                        onValueChange = { viewModelPromotorNuevaVisita.observaciones_sonido.value = it },
                        label = { Text("Observaciones") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Comment,
                                contentDescription = "observaciones"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        elevation = ButtonDefaults.elevation(defaultElevation = 5.dp),
                        shape = RoundedCornerShape(10),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.reds)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = "Precio Inicio",
                        )
                    }
                }
            }
        }
    }
}
@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ObservacionesCompetencia(
    card8: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel
) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }
    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.observar),
                            contentDescription ="IconList",
                            modifier = Modifier.padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = card8.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent8(expanded, viewModelPromotorNuevaVisita)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent8(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita : PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = listOf("ZITRO","AGS", "AMBRA GAMING", "BETSTONE BINGO", "BLUEBERI","DEGESTEC", "EIBE","FBM","IGT LUDICUS","INTERVISION","JCB GAMING","JESTRONIC","KONAMI BINGO","LATINA WORLD GAMING","LUDICUS/ZEST GAMMING","METRONIA / BEMEX","PACHINKO","R. FRANCO","RCT","SABIA");
                    var selectedText by remember { mutableStateOf("") }
                    var observaciones by remember { mutableStateOf("") }
                    var positivo by remember { mutableStateOf(false) }
                    var negativo by remember { mutableStateOf(false) }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon =
                        if (expanded)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.KeyboardArrowDown
                    val focusManager = LocalFocusManager.current
                    Text(text = "Calificacion",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth(.5f)
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.CheckCircle, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "Positivo",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(CenterVertically),
                                checked = positivo,
                                onCheckedChange = { positivo = it
                                if(positivo==true){
                                    viewModelPromotorNuevaVisita.calificacion_competencia.value = 1
                                    negativo = false
                                }
                                }
                            )
                        }
                        Spacer(Modifier.width(5.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(50.dp)
                                .fillMaxWidth()
                                .background(color = blackdark)
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = CenterVertically
                        ) {
                            Icon(Icons.Filled.CheckCircleOutline, "Diferencia")
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "Negativo",
                                fontStyle = FontStyle.Normal,
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 16.sp
                            )
                            Checkbox(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .align(Alignment.CenterVertically),
                                checked = negativo,
                                onCheckedChange = { negativo = it
                                    if(negativo==true){
                                        viewModelPromotorNuevaVisita.calificacion_competencia.value = 0
                                        positivo = false
                                    }
                                }
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.provedor_competencia.value,
                        onValueChange = { selectedText },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //This value is used to assign to the DropDown the same width
                                textfieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Seleccionar Provedor")},
                        trailingIcon = {
                            Icon(icon,"contentDescription",
                                Modifier.clickable { expanded = !expanded })
                        }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                    ) {
                        suggestions.forEach { label ->
                            DropdownMenuItem(onClick = {
                                viewModelPromotorNuevaVisita.provedor_competencia.value = label
                                expanded = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.observaciones_competencia.value,
                        onValueChange = { viewModelPromotorNuevaVisita.observaciones_competencia.value = it },
                        label = { Text("Observaciones") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Comment,
                                contentDescription = "observaciones"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        elevation = ButtonDefaults.elevation(defaultElevation = 5.dp),
                        shape = RoundedCornerShape(10),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.reds)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = "Precio Inicio",
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.propuestas_competencia.value,
                        onValueChange = { viewModelPromotorNuevaVisita.propuestas_competencia.value = it },
                        label = { Text("Propuestas") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Comment,
                                contentDescription = "observaciones"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.conclucion_competencia.value,
                        onValueChange = { viewModelPromotorNuevaVisita.conclucion_competencia.value = it },
                        label = { Text("Conclusión") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Comment,
                                contentDescription = "observaciones"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(
                        value = viewModelPromotorNuevaVisita.observaciones_generales_competencia.value,
                        onValueChange = { viewModelPromotorNuevaVisita.observaciones_generales_competencia.value  = it },
                        label = { Text("Observaciones Generales") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Comment,
                                contentDescription = "observaciones"
                            )
                        }
                    )
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}
@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun FoliosTecnicos(
    card9: SampleData,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
    viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel

) {
    val transitionState = remember { MutableTransitionState(expanded).apply {
        targetState = !expanded
    }}
    val transition = updateTransition(targetState = transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = ExpandAnimation)
    }, label = "bgColorTransition") {
        if (expanded) blackdark else blackdark
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = ExpandAnimation)
    }, label = "elevationTransition") {
        if (expanded) 20.dp else 5.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = ExpandAnimation,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        15.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = ExpandAnimation)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }

    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)){
                        Image(painter = painterResource(id = R.drawable.nota),
                            contentDescription ="IconList",
                            modifier = Modifier.padding(start = 10.dp))
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = card9.title,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 25.dp
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .align(CenterVertically)
                    ) {
                        CardArrow(
                            degrees = arrowRotationDegree,
                            onClick = onCardArrowClick
                        )
                    }
                }
            }
            ExpandableContent9(expanded, viewModelPromotorNuevaVisita)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent9(
    expanded: Boolean = true,
    viewModelPromotorNuevaVisita : PromotorNuevaVisitaViewModel
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FadeInAnimation,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(ExpandAnimation))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FadeOutAnimation,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(CollapseAnimation))
    }

    AnimatedVisibility(
        visible = expanded,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = listOf("ZITRO","AGS", "AMBRA GAMING", "BETSTONE BINGO", "BLUEBERI","DEGESTEC", "EIBE","FBM","IGT LUDICUS","INTERVISION","JCB GAMING","JESTRONIC","KONAMI BINGO","LATINA WORLD GAMING","LUDICUS/ZEST GAMMING","METRONIA / BEMEX","PACHINKO","R. FRANCO","RCT","SABIA");
                    var selectedText by remember { mutableStateOf("") }
                    var observaciones by remember { mutableStateOf("") }
                    var positivo by remember { mutableStateOf(false) }
                    var negativo by remember { mutableStateOf(false) }
                    var textfieldSize by remember { mutableStateOf(Size.Zero)}
                    val icon =
                        if (expanded)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.KeyboardArrowDown
                    val focusManager = LocalFocusManager.current
                    Text(text = "Folio",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.SnippetFolder, "Diferencia")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.folio_tecnico.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Fecha de Apertura",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.DateRange, "Diferencia")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.fecha_apertura_tecnico.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Estatus",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.QueryStats, "Diferencia")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.estatus_tecnico.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Detalles",
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = graydark)
                        .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = CenterVertically) {
                        Icon(Icons.Filled.Details, "Diferencia")
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)) {
                            Text(text = "${viewModelPromotorNuevaVisita.detalles_tecnicos.value}",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}