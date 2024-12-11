package com.demo.foodbite.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.demo.foodbite.R
import com.demo.foodbite.viewmodels.UserViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun RegisterScreen(navController: NavHostController, viewModel: UserViewModel) {
    Scaffold(
        content = { paddingValues ->
            RegisterScreenContent(paddingValues = paddingValues, navController = navController,viewModel)
        }
    )
}


@Composable
fun RegisterScreenContent(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: UserViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple_700))
            .padding(paddingValues)
            .background(color = colorResource(id = R.color.white))
    ) {
        HeaderRegister(navController)
        Spacer(modifier = Modifier.padding(top = 50.dp))
        RegisterForm(navController,viewModel)
    }
}

@Composable
fun HeaderRegister(navController: NavController) {
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
            BackButtonRegister(navController)
            WelcomeRegisterText()
        }
    }
}

@Composable
fun BackButtonRegister(navController: NavController) {
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
fun WelcomeRegisterText() {
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
            text = stringResource(id = R.string.register_to_food_bite),
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            modifier = Modifier.padding(start = 15.dp, top = 10.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterForm(navController: NavController, viewModel: UserViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        //username TextField
        TextField(
            value = viewModel.username,
            onValueChange = { viewModel.username = it },
            label = { Text("Enter Username") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
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
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "user Icon",
                    tint = colorResource(id = R.color.black)
                )
            },
            modifier = Modifier.fillMaxWidth()
        )


        //email Text Field
        TextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = { Text("Enter Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
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
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
        )


        //select DOB Field

        var selectedDate by remember { mutableStateOf<Long?>(null) }
        var showModal by remember { mutableStateOf(false) }
        TextField(
            value = selectedDate?.let { convertMillisToDate(it) } ?: viewModel.dob,
            onValueChange = { },
            label = { Text("DOB") },
            placeholder = { Text("DD/MM/YYYY") },
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
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
                    painter = painterResource(id = R.drawable.ic_calender),
                    contentDescription = "calender Icon",
                    tint = colorResource(id = R.color.black)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .pointerInput(selectedDate) {
                    awaitEachGesture {
                        // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
                        // in the Initial pass to observe events before the text field consumes them
                        // in the Main pass.
                        awaitFirstDown(pass = PointerEventPass.Initial)
                        val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                        if (upEvent != null) {
                            showModal = true
                        }
                    }
                }
        )
        if (showModal) {
            DatePickerModal(
                onDateSelected = {
                    selectedDate = it
                    viewModel.dob = convertMillisToDate(it!!) // Update the ViewModel
                },
                onDismiss = { showModal = false }
            )
        }


        //password TextField

        TextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            label = { Text("Enter Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
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
                    painter = painterResource(id = R.drawable.ic_password),
                    contentDescription = "Password Icon",
                    tint = colorResource(id = R.color.black)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
        )


        //Confirm Password

        TextField(
            value = viewModel.confirmPassword,
            onValueChange = { viewModel.confirmPassword = it },
            label = { Text("Enter Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
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
                    painter = painterResource(id = R.drawable.ic_password),
                    contentDescription = "Password Icon",
                    tint = colorResource(id = R.color.black)
                )
            },
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
        )

        SignUpButton(onClick = { navController.navigate("main_screen")})

        LoginTextClick(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}



@Composable
fun SignUpButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.purple_700)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
    ) {
        Text(
            text = "Register",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoginTextClick(navController: NavController) {
    val annotatedString = buildAnnotatedString {
        append("Don't have an account? ")
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
        modifier = Modifier.padding(top = 50.dp)
    )
}