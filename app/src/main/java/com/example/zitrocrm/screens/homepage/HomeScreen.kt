package com.example.zitrocrm.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.FloatTweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.zitrocrm.R
import com.example.zitrocrm.navigation.Destination
import com.example.zitrocrm.repository.DataStorePreferenceRepository
import com.example.zitrocrm.ui.theme.blackdark
import com.example.zitrocrm.ui.theme.graydark
import com.example.zitrocrm.ui.theme.reds
import com.example.zitrocrm.viewmodel.LoginViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val dataStorePreferenceRepository: DataStorePreferenceRepository = DataStorePreferenceRepository.getInstance(context)
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val getUserName ="" //viewModel.userName.observeAsState().value

    val loginViewModel: LoginViewModel = viewModel()
    val username = "" //viewModel.usuario_user//viewModel.usuario_name.value
    val userlastname = ""//viewModel.usuario_lastname.value
    val userarea =0 //viewModel.usuario_area.value
    val fecha = DateTimeFormatter.ofPattern("MMMM")
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(
            elevation = 0.dp,
            modifier = Modifier.height(90.dp),
            title = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(R.drawable.componente_23__13),
                        contentDescription = "",
                        modifier = Modifier
                            .clickable { scope.launch { scaffoldState.drawerState.open() } }
                            .padding(0.dp, 10.dp, 0.dp, 10.dp)
                            .align(Alignment.TopStart)
                            .size(40.dp),
                    )
                    Column(modifier = Modifier
                        .padding(50.dp,10.dp,70.dp,0.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "Bienvenido, ${username} ${userlastname}",
                            color = Color.White,
                            style = TextStyle(
                                fontStyle = FontStyle.Normal,
                                fontSize = 18.sp
                            )
                        )
                        Text(
                            text = "Area ${userarea}",
                            color = Color.White,
                            style = TextStyle(
                                fontStyle = FontStyle.Normal,
                                fontSize = 18.sp
                            )
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.crm_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(10.dp)
                    )
                }
            },
            backgroundColor = reds,
        ) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

            }){
                Image(
                    painter = painterResource(R.drawable.button_filter_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(57.dp)
                        .clip(CircleShape)
                        .clickable { navController.navigate(route = Destination.FilterScreen.route) }
                )
        } },
        drawerContent = {
                drawercontent(navController,loginViewModel)
                        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = ScrollState(1))){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(
                        modifier = Modifier
                            .height(10.dp))
                    Text(
                        text = "${fecha.format(LocalDateTime.now())}",
                        fontStyle = FontStyle.Normal,
                        fontSize = 20.sp)
                    Spacer(
                        modifier = Modifier.height(10.dp))
                    MessageCard(navController)
                }
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MessageCardd(navController: NavController) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp))
    {
        item {
            contentclient(navController)
        }
        item {
            contentsalas(navController)
        }
        item {
            contentmaquinas(navController)
        }
        item {
            contentcuentas(navController)
        }
        item {
            contentnegociaciones(navController)
        }
        item {
            contentcontratos(navController)
        }
        item {
            contentfacturas(navController)
        }
        item {
            contentventarefacciones(navController)
        }
    }
}
@Composable
private fun MessageCard(navController: NavController) {
    Row(
        Modifier
            .fillMaxHeight()
            .padding(10.dp)) {
        Column(Modifier
            .weight(1f)) {
            contentclient(navController)
        }
        Spacer(
            modifier = Modifier
                .width(10.dp))
        Column(Modifier
            .weight(1f)) {
            contentsalas(navController)
        }
    }
    Row(
        Modifier
            .fillMaxHeight()
            .padding(10.dp)) {
        Column(Modifier
            .weight(1f)){
            contentmaquinas(navController)
        }
        Spacer(
            modifier = Modifier
                .width(10.dp))
        Column(Modifier
            .weight(1f)){
        contentcuentas(navController)
        }
    }
    Row(
        Modifier
            .fillMaxHeight()
            .padding(10.dp)) {
        contentnegociaciones(navController)
    }
    Row(
        Modifier
            .fillMaxHeight()
            .padding(10.dp)) {
        Column(Modifier
            .weight(1f)){
        contentcontratos(navController)
        }
        Spacer(
            modifier = Modifier
                .width(10.dp))
        Column(Modifier
            .weight(1f)){
        contentfacturas(navController)
        }
    }
    Row(
        Modifier
            .fillMaxHeight()
            .padding(10.dp)) {
        contentventarefacciones(navController)
    }
}

//CONTENTS//
@Composable
private fun contentclient(navController: NavController){

    val cliente = "CLIENTE"
    val maquinasventa = "Maquinas en Venta"
    val intmaquinasventa = "60"
    val maquinasrenta = "Maquinas en Renta"
    val intmaquinasrenta = "50"
    var vermas = "Ver Mas.."

    Column(
        modifier = Modifier
            .clickable { }
            .clip(RoundedCornerShape(10.dp))
            .background(graydark)
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = painterResource(R.drawable.icon_cliente),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = cliente,
            fontStyle = FontStyle.Normal)
        Text(
            text = maquinasventa,
            fontStyle = FontStyle.Normal)
        Text(
            text = intmaquinasventa,
            fontStyle = FontStyle.Normal,color = Color.Red)
        Text(
            text = maquinasrenta,
            fontStyle = FontStyle.Normal)
        Text(
            text = intmaquinasrenta,
            fontStyle = FontStyle.Normal,color = Color.Blue)
        PieChart()
        Text(
            text = vermas,
            fontStyle = FontStyle.Normal)
    }
}

@Composable
private fun contentsalas(navController: NavController){
    Column(modifier = Modifier
        .clickable { navController.navigate("salas_screen") }
        .clip(RoundedCornerShape(10.dp))
        .background(blackdark)
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val cliente = "SALAS"
        val maquinasventa = "Visitas Mensuales"
        val intmaquinasventa = "60"
        val maquinasrenta = "Servicios Mensuales"
        val intmaquinasrenta = "50"
        var vermas = "Ver Mas.."
        Image(
            painter = painterResource(R.drawable.salas_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = cliente,
            fontStyle = FontStyle.Normal)
        Text(
            text = maquinasventa,
            fontStyle = FontStyle.Normal)
        Text(
            text = intmaquinasventa,
            fontStyle = FontStyle.Normal,
            color = Color.Red)
        Text(
            text = maquinasrenta,
            fontStyle = FontStyle.Normal)
        Text(
            text = intmaquinasrenta,
            fontStyle = FontStyle.Normal,
            color = Color.Blue)
        PieChart()
        Text(
            text = vermas ,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
private fun contentmaquinas(navController: NavController){
    Column(modifier = Modifier
        .clickable { }
        .clip(RoundedCornerShape(10.dp))
        .background(blackdark)
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val maquinas = "MAQUINAS"
        val pedidomaquinas = "Pedido de Maquinas"
        val intpedido = "60"
        val inventario = "Inventario"
        val intinventario = "50"
        var vermas = "Ver Mas.."
        Image(
            painter = painterResource(R.drawable.maquinas_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = maquinas,
            fontStyle = FontStyle.Normal)
        Text(
            text = pedidomaquinas,
            fontStyle = FontStyle.Normal)
        Text(
            text = intpedido,
            fontStyle = FontStyle.Normal,
            color = Color.Red)
        Text(
            text = inventario,
            fontStyle = FontStyle.Normal)
        Text(
            text = intinventario,
            fontStyle = FontStyle.Normal,
            color = Color.Blue)
        PieChart()
        Text(
            text = vermas ,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
private fun contentcuentas(navController: NavController){
    Column(modifier = Modifier
        .clickable { }
        .clip(RoundedCornerShape(10.dp))
        .background(graydark)
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val cuentas = "CUENTAS"
        val totalcuentas = "Total Cuentas"
        val inttotal = "60"
        val maquinas = "Maquinas"
        val intmaquinas = "50"
        var vermas = "Ver Mas.."
        Image(
            painter = painterResource(R.drawable.inventario_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = cuentas,
            fontStyle = FontStyle.Normal)
        Text(
            text = totalcuentas,
            fontStyle = FontStyle.Normal)
        Text(
            text = inttotal,
            fontStyle = FontStyle.Normal,
            color = Color.Red)
        Text(
            text = maquinas,
            fontStyle = FontStyle.Normal)
        Text(
            text = intmaquinas,
            fontStyle = FontStyle.Normal,
            color = Color.Blue)
        PieChart()
        Text(
            text = vermas ,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
private fun contentnegociaciones  (navController: NavController){
    Column(modifier = Modifier
        .clickable { }
        .clip(RoundedCornerShape(10.dp))
        .background(blackdark)
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val negociaciones = "NEGOCIACIONES"
        val autorizar = "Autorizar"
        val intautorizar = "60"
        val aceptadas = "Aceptadas"
        val intaceptadas = "60"
        val aprobar = "Aprobar"
        val intaprobar = "40"
        val rechazadas = "Rechazadas"
        val intrechazadas = "40"
        var vermas = "Ver Mas.."
        Image(
            painter = painterResource(R.drawable.negociaciones_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = negociaciones,
            fontStyle = FontStyle.Normal)
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center) {
            Column() {
                Text(
                    text = autorizar,
                    fontStyle = FontStyle.Normal)
                Text(
                    text = intautorizar,
                    fontStyle = FontStyle.Normal,
                    color = Color.Red)
                Text(
                    text = aceptadas,
                    fontStyle = FontStyle.Normal)
                Text(
                    text = intaceptadas,
                    fontStyle = FontStyle.Normal,
                    color = Color.Blue)
            }
            Spacer(
                modifier = Modifier.width(90.dp))
            Column() {
                Text(
                    text = aprobar,
                    fontStyle = FontStyle.Normal)
                Text(
                    text = intaprobar,
                    fontStyle = FontStyle.Normal,
                    color = Color.Red)
                Text(
                    text = rechazadas,
                    fontStyle = FontStyle.Normal)
                Text(
                    text = intrechazadas,
                    fontStyle = FontStyle.Normal,
                    color = Color.Blue)

            }
        }
        PieChart()
        Text(
            text = vermas ,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
private fun contentcontratos(navController: NavController){
    Column(modifier = Modifier
        .clickable { }
        .clip(RoundedCornerShape(10.dp))
        .background(graydark)
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val contratos = "CONTRATOS"
        val abiertos = "Abiertos"
        val intabiertos = "60"
        val cerrados = "Cerrados"
        val intcerrados = "50"
        var vermas = "Ver Mas.."
        Image(
            painter = painterResource(R.drawable.contratos_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = contratos,
            fontStyle = FontStyle.Normal)
        Text(
            text = abiertos,
            fontStyle = FontStyle.Normal)
        Text(
            text = intabiertos,
            fontStyle = FontStyle.Normal,
            color = Color.Red)
        Text(
            text = cerrados,
            fontStyle = FontStyle.Normal)
        Text(
            text = intcerrados,
            fontStyle = FontStyle.Normal,
            color = Color.Blue)
        PieChart()
        Text(
            text = vermas ,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
private fun contentfacturas(navController: NavController){
    Column(modifier = Modifier
        .clickable { }
        .clip(RoundedCornerShape(10.dp))
        .background(blackdark)
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val facturas = "FACTURAS"
        val estemes = "Este mes"
        val intestemes = "60"
        val mespasado = "Mes Pasado"
        val intmespasado = "50"
        var vermas = "Ver Mas.."
        Image(
            painter = painterResource(R.drawable.facturas_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = facturas,
            fontStyle = FontStyle.Normal)
        Text(
            text = estemes,
            fontStyle = FontStyle.Normal)
        Text(
            text = intestemes,
            fontStyle = FontStyle.Normal,
            color = Color.Red)
        Text(
            text = mespasado,
            fontStyle = FontStyle.Normal)
        Text(
            text = intmespasado,
            fontStyle = FontStyle.Normal,
            color = Color.Blue)
        PieChart()
        Text(
            text = vermas ,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
private fun contentventarefacciones (navController: NavController){
    Column(modifier = Modifier
        .clickable { }
        .clip(RoundedCornerShape(10.dp))
        .background(graydark)
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val negociaciones = "VENTA DE REFACCIONES"
        val autorizar = "Solicitudes"
        val intautorizar = "60"
        val aceptadas = "Cotizaciones"
        val intaceptadas = "60"
        val aprobar = "Facturacion de Refacciones"
        val intaprobar = "40"
        var vermas = "Ver Mas.."
        Image(
            painter = painterResource(R.drawable.venta_refacciones_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = negociaciones,
            fontStyle = FontStyle.Normal)
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center) {
            Column() {
                Text(
                    text = autorizar,
                    fontStyle = FontStyle.Normal)
                Text(
                    text = intautorizar,
                    fontStyle = FontStyle.Normal,
                    color = Color.Red)
                Text(
                    text = aceptadas,
                    fontStyle = FontStyle.Normal)
                Text(
                    text = intaceptadas,
                    fontStyle = FontStyle.Normal,
                    color = Color.Blue)
            }
            Spacer(
                modifier = Modifier.width(90.dp))
            Column() {
                Text(
                    text = aprobar,
                    fontStyle = FontStyle.Normal)
                Text(
                    text = intaprobar,
                    fontStyle = FontStyle.Normal,
                    color = Color.Red)
            }
        }
        PieChart()
        Text(
            text = vermas ,
            fontStyle = FontStyle.Normal
        )
    }
}

private fun getPositionFromAngle(
    angles: List<Float>,
    touchAngle: Double,
): Int {
    var totalAngle = 0f
    for ((i, angle) in angles.withIndex()) {
        totalAngle += angle
        if (touchAngle <= totalAngle) {
            return i
        }
    }
    return -1
}

@Composable
fun PieChart() {
    val context = LocalContext.current
    val point = listOf(10f, 40f, 25f, 85f, 100f, 65f)
    val color = listOf(
        Color.Blue,
        Color.Yellow,
        Color.Green,
        Color.Gray,
        Color.Red,
        Color.Cyan
    )
    val sum = point.sum()
    var startAngle = 0f
    val radius = 215f
    val rect = Rect(Offset(-radius, -radius), Size(2 * radius, 2 * radius))
    val path = Path()
    val angles = mutableListOf<Float>()
    var start by remember { mutableStateOf(false) }
    val sweepPre by animateFloatAsState(
        targetValue = if (start) 1f else 0f,
        animationSpec = FloatTweenSpec(duration = 1000)
    )
    Canvas(
        modifier = Modifier
            .size(160.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        val x = it.x - radius
                        val y = it.y - radius
                        var touchAngle = Math.toDegrees(Math.atan2(y.toDouble(), x.toDouble()))
                        if (x < 0 && y < 0 || x > 0 && y < 0) {
                            touchAngle += 360
                        }
                        val position =
                            getPositionFromAngle(touchAngle = touchAngle, angles = angles)
                        Toast
                            .makeText(context, "onTap: $position", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
    ) {
        translate(radius, radius) {
            start = true
            for ((i, p) in point.withIndex()) {
                val sweepAngle = p / sum * 360f
                path.moveTo(0f, 0f)
                path.arcTo(rect = rect, startAngle, sweepAngle * sweepPre, false)
                angles.add(sweepAngle)
                drawPath(path = path, color = color[i])
                path.reset()
                startAngle += sweepAngle
            }
        }
    }
}

