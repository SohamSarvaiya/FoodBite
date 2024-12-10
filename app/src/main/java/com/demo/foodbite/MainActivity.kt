package com.demo.foodbite

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.demo.foodbite.app.NavControllerClass
import com.demo.foodbite.ui.theme.FoodBiteTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodBiteTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    NavControllerClass()

}


