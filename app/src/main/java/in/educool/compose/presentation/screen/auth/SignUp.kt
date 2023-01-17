package `in`.educool.compose.presentation.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.educool.compose.R
import `in`.educool.compose.ui.theme.*

@Composable
fun SignUp() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        HeadingAndButtons(
            email = email,
            onEmailChange = { email = it },
            password = password,
            onPasswordChange = { password = it },
            confirmPassword = confirmPassword,
            onConfirmPasswordChange = { confirmPassword = it },
            modifier = Modifier.offset(y = (-148).dp)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HeadingAndButtons(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = Rosario, fontWeight = FontWeight.Bold)) {
                    withStyle(
                        SpanStyle(
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            color = Blue
                        )
                    ) {
                        append("Sign Up\n")
                    }

                    withStyle(
                        SpanStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Yellow
                        )
                    ) {
                        append("Get Started")
                    }
                }
            },
            lineHeight = 36.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(18.dp))

        EmailField(email = email, onEmailChange = onEmailChange, labelText = "Enter your email")

        Spacer(modifier = Modifier.height(16.dp))

        PasswordField(
            password = password,
            onPasswordChange = onPasswordChange,
            labelText = "Enter Your Password"
        )

        Spacer(modifier = Modifier.height(8.dp))

        PasswordField(
            password = confirmPassword,
            onPasswordChange = onConfirmPasswordChange,
            labelText = "Confirm Your Password"
        )

        Spacer(modifier = Modifier.height(16.dp))

        AuthButton("Sign Up") {}

        LowerLogInPart("Sign Up using Google")

    }

}
