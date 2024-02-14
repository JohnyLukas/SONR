package com.johnydev.sonr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.johnydev.sonr.ui.MainScreen
import com.johnydev.sonr.ui.theme.SONRTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SONRTheme {
                MainScreen(viewModel)
            }
        }
    }
}