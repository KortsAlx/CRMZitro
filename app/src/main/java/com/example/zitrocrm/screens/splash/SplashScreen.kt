package com.example.zitrocrm.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zitrocrm.R
import com.example.zitrocrm.navigation.Destination
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    Scaffold() {
        Image(
            painter = painterResource(R.drawable.backgroud_crmm),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Modifier.padding(0.dp)
        val scale = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(
                    durationMillis = 1200,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    }
                )
            )
            delay(3000L)
            navController.navigate(route = Destination.LoginScreen.route ){
                popUpTo(route = Destination.SplashScreen.route) {
                    inclusive = true
                }
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.log_splash),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value)
            )
        }
    }
}

