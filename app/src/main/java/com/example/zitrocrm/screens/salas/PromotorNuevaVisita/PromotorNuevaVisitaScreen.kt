package com.example.zitrocrm.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zitrocrm.R
//import com.example.zitrocrm.screens.salas.ExpandableScreen
import com.example.zitrocrm.screens.salas.PromotorNuevaVisita.PromotorNuevaVisitaViewModel
import com.example.zitrocrm.ui.theme.blackdark
import com.example.zitrocrm.ui.theme.graydark
import com.example.zitrocrm.ui.theme.reds
import java.util.*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PromotorNewScreenn (navController: NavController,viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel){
    val checkedState = remember { mutableStateOf(false) }
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
                            Text(text = "Bingo",
                                modifier = Modifier.align(CenterVertically),
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 10.sp,
                                color = Color.White)
                            Switch(
                                checked = checkedState.value,
                                onCheckedChange = { checkedState.value = it },
                                modifier = Modifier.align(CenterVertically),
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    uncheckedThumbColor = Color.White,
                                    checkedTrackColor = Color.LightGray,
                                    uncheckedTrackColor = Color.LightGray,
                                    checkedTrackAlpha = 1.0f,
                                    uncheckedTrackAlpha = 1.0f
                                )
                            )
                            Text(text = "Slots",
                                modifier = Modifier.align(CenterVertically),
                                style = MaterialTheme.typography.subtitle2,
                                fontSize = 10.sp,
                                color = Color.White)
                        }
                    }
                },
                backgroundColor = reds,
            )
        }
    )
    {
        //ExpandableScreen(viewModelPromotorNuevaVisita)
    }
}

