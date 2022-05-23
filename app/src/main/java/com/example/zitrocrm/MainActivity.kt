package com.example.zitrocrm

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zitrocrm.navigation.NavigationScreen
import com.example.zitrocrm.repository.DataStorePreferenceRepository
import com.example.zitrocrm.repository.DataStoreViewModel
import com.example.zitrocrm.ui.theme.ZITROCRMTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZITROCRMTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationScreen()
                }
            }
        }
    }
}







