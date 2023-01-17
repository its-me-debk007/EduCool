package `in`.educool.compose.presentation.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import `in`.educool.compose.R

@Composable
fun ForgotPassword() {
    var email by rememberSaveable { mutableStateOf("") }
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .offset(y = (-148).dp)
        ) {

            AuthHeading(heading = "Enter Your Email Id")

            Spacer(modifier = Modifier.height(24.dp))

            EmailField(
                email = email,
                onEmailChange = { email = it },
                labelText = "Enter your email",
                imeAction = ImeAction.Go
            )

            Spacer(modifier = Modifier.height(24.dp))

            AuthButton(text = "Verify") {}

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
