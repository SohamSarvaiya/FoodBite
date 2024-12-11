package com.demo.foodbite.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.demo.foodbite.R

@Composable
fun SelectionScreen(navController: NavController) {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.purple_700))
                    .padding(paddingValues)
                    .background(color = colorResource(id = R.color.white))

            ) {
                HeaderSection()
                Spacer(modifier = Modifier.padding(top = 40.dp))
                ContentSection(navController)
            }
        }
    )
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .height(350.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        // Image starts right at the top, under the status bar
        Image(
            painter = painterResource(id = R.drawable.curve),
            contentDescription = "Img Desc",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.TopCenter), // Align image to top
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.food_logo),
            contentDescription = "logo Image",
            modifier = Modifier
                .height(180.dp)
                .width(180.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun ContentSection(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.str1),
            color = Color.Black,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.nunito_bold)),
            style = TextStyle(lineHeight = 38.sp)
        )

        Text(
            text = stringResource(id = R.string.str2),
            color = colorResource(id = R.color.grey),
            fontSize = 21.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            style = TextStyle(lineHeight = 25.sp),
            modifier = Modifier.padding(top = 20.dp)
        )

        LoginButton(navController)

        RegisterButton(navController)

        SignInText(navController)
    }
}

@Composable
fun LoginButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("login_screen") },
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.purple_700)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp)
    ) {
        Text(
            text = "Login",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RegisterButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("register_screen") },
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = colorResource(id = R.color.purple_700)
        ),
        border = BorderStroke(1.dp, colorResource(id = R.color.purple_700)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Register",
            color = colorResource(id = R.color.purple_700),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SignInText(navController: NavController) {
    val annotatedString = buildAnnotatedString {
        append("Already have an account? ")
        withStyle(style = SpanStyle(color = colorResource(id = R.color.purple_700))) {
            append("Sign In")
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { navController.navigate("login_screen") },
        style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.grey)
        ),
        modifier = Modifier.padding(top = 70.dp)
    )

}
