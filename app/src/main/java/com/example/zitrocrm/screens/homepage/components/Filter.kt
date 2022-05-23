package com.example.zitrocrm.screens.homepage.components

import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.zitrocrm.R
import com.example.zitrocrm.navigation.Destination
import com.example.zitrocrm.ui.theme.reds

@Composable
fun FilterScreen(navController: NavController){
    Scaffold(
    topBar = { CustomTopAppBarSalas(navController) }
    ) {
        Column() {
            dropDownMenuCliente(navController)
        }
    }
}

@Composable
private fun CustomTopAppBarSalas(navController: NavController) {
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
            }
        },
        backgroundColor = reds,
    )
}
@Composable
private fun dropDownMenuCliente(navController: NavController
    /**onclickLogin: (selectedText: String, selectedText2: String, selectedText3: String)**/)
{
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Todos","ARAMAZD", "ANDES", "BIG BOLA", "CASINO ROCK","CODERE", "ZITRO","GOLDEN GRUP","ARAMAZD GAMING")
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    /****/
    var expanded2 by remember { mutableStateOf(false) }
    val suggestions2 = listOf("Todos","CENTRO","DFZ1","PUEBLA/VERACRUZ","GUADALAJARA","MONTERREY","PACIFICO","TIJUANA","DFZ2","PENINSULA","DFZ3","DFZ4")
    var selectedText2 by remember { mutableStateOf("") }
    var textfieldSize2 by remember { mutableStateOf(Size.Zero)}
    val icon2 = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    /****/

    var expanded3 by remember { mutableStateOf(false) }
    val suggestions3 = listOf("Todos")
    var selectedText3 by remember { mutableStateOf("") }

    var textfieldSize3 by remember { mutableStateOf(Size.Zero)}

    val icon3 = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    //val isValidate by derivedStateOf { selectedText.isNotBlank() && selectedText2.isNotBlank() && selectedText3.isBlank() }

    Column(Modifier.padding(20.dp)) {

        Text(text = "Filtrar Busqueda",
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(vertical = 15.dp),
            style = MaterialTheme.typography.subtitle2,
            fontSize = 19.sp)
        
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = {Text("Cliente")},
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
                    selectedText = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText2,
            onValueChange = { selectedText2 = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize2 = coordinates.size.toSize()
                },
            label = {Text("Region")},
            trailingIcon = {
                Icon(icon2,"contentDescription",
                    Modifier.clickable { expanded2 = !expanded2 })
            }
        )
        DropdownMenu(
            expanded = expanded2,
            onDismissRequest = { expanded2 = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize2.width.toDp()})
        ) {
            suggestions2.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText2 = label
                    expanded2 = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText3,
            onValueChange = { selectedText3 = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize3 = coordinates.size.toSize()
                },
            label = {Text("Sala")},
            trailingIcon = {
                Icon(icon3,"contentDescription",
                    Modifier.clickable { expanded3 = !expanded3 })
            }
        )
        DropdownMenu(
            expanded = expanded3,
            onDismissRequest = { expanded3 = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize3.width.toDp()})
        ) {
            suggestions3.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText3 = label
                    expanded3 = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
    Column(modifier = Modifier.padding(20.dp)) {
        buttonFiltrar(/**onclick = { onclickLogin(selectedText, selectedText2, selectedText3) },
        enabled = isValidate**/ navController)
    }
}


@Composable
private fun buttonFiltrar (navController: NavController
    //onclick: () -> Unit,
    //enabled: Boolean
){
    Button(
        onClick = {
            navController.popBackStack()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        //elevation = ButtonDefaults.elevation(defaultElevation = 5.dp),
       // enabled = enabled,
        shape = RoundedCornerShape(10),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.reds)
        )
    ) {
        Text(
            text = "Filtrar",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}


