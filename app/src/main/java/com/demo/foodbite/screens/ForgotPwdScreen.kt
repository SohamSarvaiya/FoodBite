package com.demo.foodbite.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.demo.foodbite.R

@Composable
fun ForgotPwdScreen(navController: NavHostController) {
    Scaffold(
        content = { paddingValues ->
            ForgotPwdScreenContent(paddingValues = paddingValues, navController = navController)
        }
    )
}

@Composable
fun ForgotPwdScreenContent(
    paddingValues: PaddingValues,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple_700))
            .padding(paddingValues)
            .background(color = colorResource(id = R.color.white))
    ) {


        HeaderForgotPwd(navController)
        Spacer(modifier = Modifier.padding(top = 50.dp))
        InstructionsSection()
        Spacer(modifier = Modifier.padding(top = 30.dp))

        ForgotPwdForm(navController)

    }
}

@Composable
fun HeaderForgotPwd(navController: NavController) {
    Box(modifier = Modifier.height(230.dp)) {
        Image(
            painter = painterResource(id = R.drawable.curve_main),
            contentDescription = "Header Image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 20.dp)) {
            BackButtonForgotScreen(navController)
            ForgotPwdText()
        }
    }
}

@Composable
fun BackButtonForgotScreen(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.arrow_left),
        contentDescription = "Back Arrow",
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .padding(5.dp)
            .clickable { navController.popBackStack() }
    )
}

@Composable
fun ForgotPwdText() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.welcome),
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            modifier = Modifier.padding(start = 10.dp, top = 15.dp)
        )
        Text(
            text = stringResource(id = R.string.forgot_),
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            modifier = Modifier.padding(start = 15.dp, top = 10.dp)
        )
    }
}


@Composable
fun InstructionsSection() {
    Text(
        text = stringResource(id = R.string.forgot_text),
        color = colorResource(id = R.color.grey),
        fontSize = 18.sp,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily(Font(R.font.nunito_medium)),
        style = TextStyle(lineHeight = 25.sp),
        modifier = Modifier.padding(20.dp)
    )
}
@Composable
fun ForgotPwdForm(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailForgotPwdTextField()
        SubmitButton(onClick = { navController.navigate("login_screen") })

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailForgotPwdTextField() {
    var email by remember { mutableStateOf("") }
    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Enter Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedIndicatorColor = colorResource(id = R.color.purple_700),
            unfocusedIndicatorColor = Color.Gray,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Gray
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "Email Icon",
                tint = colorResource(id = R.color.black)
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun SubmitButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.purple_700)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Text(
            text = "Submit",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}