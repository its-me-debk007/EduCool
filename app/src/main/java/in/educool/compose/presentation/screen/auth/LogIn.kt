package `in`.educool.compose.presentation.screen.auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.educool.compose.R
import `in`.educool.compose.ui.theme.*

@Preview(showBackground = true)
@Composable
fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
            modifier = Modifier.offset(y = (-120).dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeadingAndButtons(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var hidePassword by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold)) {
                    append("    Log In\n")
                }

                withStyle(
                    SpanStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Yellow
                    )
                ) {
                    append("Welcome Back")
                }
            },
            lineHeight = 36.sp,
            modifier = Modifier.align(CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            singleLine = true,
            label = {
                Text(
                    text = "Email Address",
                    style = TextFieldLabel,
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            singleLine = true,
            onValueChange = onPasswordChange,
            label = {
                Text(
                    text = "Password",
                    style = TextFieldLabel,
                )
            },
            trailingIcon = {
                val icon =
                    if (hidePassword) R.drawable.ic_visibility_off else R.drawable.ic_visibility

                val description = if (hidePassword) "Show password" else "Hide password"

                IconButton(onClick = { hidePassword = !hidePassword }) {
                    Icon(painter = painterResource(icon), contentDescription = description)
                }
            },
            visualTransformation = if (hidePassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Forgot Password",
            style = TextFieldLabel,
            color = Blue,
            modifier = Modifier
                .padding(start = 4.dp)
                .clickable { })

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Log In",
                fontFamily = ReemKufi,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
        }

        OrLabel()

        SignInWithGoogle(modifier = Modifier.align(CenterHorizontally)) {}

        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = ReemKufi, fontSize = 18.sp)) {
                    withStyle(SpanStyle(color = Color.Black)) {
                        append("Don’t have an account? ")
                    }
                    withStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            color = LightBlue
                        )
                    ) {
                        append("Sign Up")
                    }
                }
            },
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 8.dp)
        )
    }

}

@Composable
fun SignInWithGoogle(modifier: Modifier, onClick: () -> Unit) {
    Row(modifier = modifier.clickable { onClick() }) {
        Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = null)

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Sign In using Google",
            fontFamily = Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
fun OrLabel() {
    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 11.dp, vertical = 16.dp)
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .weight(3f)
                .background(Gray)
        )

        Text(
            text = "Or",
            fontFamily = Roboto,
            fontWeight = FontWeight.Medium,
            color = Gray,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .weight(3f)
                .background(Gray)
        )

    }
}
