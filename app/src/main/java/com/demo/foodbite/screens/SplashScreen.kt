package com.demo.foodbite.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
                Image(
                    painter = painterResource(id = R.drawable.food_logo),
                    contentDescription = "logo Image",
                    modifier = Modifier
                        .height(250.dp)
                        .width(250.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.FillBounds
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