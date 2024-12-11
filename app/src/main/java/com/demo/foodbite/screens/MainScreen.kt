package com.demo.foodbite.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.demo.foodbite.R
import com.demo.foodbite.viewmodels.UserViewModel

@Composable
fun MainScreen(navController: NavHostController, viewModel: UserViewModel) {
    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        contentAlignment = Alignment.Center

    ){
        Column() {

            Text(
                text = "Welcome",
                color = Color.Black,
                fontSize = 21.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.nunito_bold)
                )
            )

            Text(
                text = "Username -  ${viewModel.username}",
                color = Color.Black,
                fontSize = 21.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.nunito_bold)
                )
            )
            Text(
                text = "Email -  ${viewModel.email}",
                color = Color.Black,
                fontSize = 21.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.nunito_bold)
                )
            )

            Text(
                text = "Date of Birth -  ${viewModel.dob}",
                color = Color.Black,
                fontSize = 21.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.nunito_bold)
                )
            )



        }



    }

}

