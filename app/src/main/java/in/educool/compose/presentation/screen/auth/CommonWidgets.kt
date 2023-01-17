package `in`.educool.compose.presentation.screen.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.educool.compose.R
import `in`.educool.compose.ui.theme.LightBlue
import `in`.educool.compose.ui.theme.ReemKufi
import `in`.educool.compose.ui.theme.TextFieldLabel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onEmailChange: (String) -> Unit, labelText: String) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        singleLine = true,
        label = {
            Text(
                text = labelText,
                style = TextFieldLabel,
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onPasswordChange: (String) -> Unit, labelText: String) {
    var hidePassword by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = password,
        singleLine = true,
        onValueChange = onPasswordChange,
        label = {
            Text(
                text = labelText,
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
            imeAction = if (labelText == "Enter Your Password") ImeAction.Next else ImeAction.Go
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LowerLogInPart(oauthLabel: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OrLabel()

        GoogleOAuth(text = oauthLabel, modifier = Modifier.align(Alignment.CenterHorizontally)) {}

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
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
                .clickable { }
        )
    }
}

@Composable
fun AuthButton(text: String, onClick: () -> Unit) {
    Button(onClick = { onClick() }, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = text,
            fontFamily = ReemKufi,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
    }
}
