package com.demo.foodbite.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.demo.foodbite.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.purple_700))
                    .padding(paddingValues),
                    contentAlignment = Alignment.Center

            ){
                Text(
                    text = "FoodBite",
                    color = Color.White,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(
                        Font((R.font.nunito_bold))
                    )
                )


                // Trigger navigation after a delay (2 seconds)
                LaunchedEffect(Unit) {
                    delay(3000)
                    navController.navigate("selection_screen")
                }
            }

        }
    )

}