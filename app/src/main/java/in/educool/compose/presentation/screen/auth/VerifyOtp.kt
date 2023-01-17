package `in`.educool.compose.presentation.screen.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import `in`.educool.compose.R
import `in`.educool.compose.presentation.viewmodel.auth.VerifyOtpViewModel
import `in`.educool.compose.ui.theme.Blue
import `in`.educool.compose.ui.theme.Rosario

@Preview(showBackground = true)
@Composable
fun VerifyOtp(viewModel: VerifyOtpViewModel = hiltViewModel()) {
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

            AuthHeading(heading = "Enter your OTP")

            Spacer(modifier = Modifier.height(24.dp))

            EmailField(
                email = email,
                onEmailChange = { email = it },
                labelText = "Enter your email"
            )

            Spacer(modifier = Modifier.height(24.dp))

            AuthButton(text = "Verify") {}

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Resend OTP" + if (viewModel.timer.value != 0) " after ${viewModel.timer.value} sec(s)" else "",
                color = Blue,
                modifier = Modifier.clickable {
                    Log.d("TIMER", viewModel.timer.value.toString())
                    if (viewModel.timer.value == 0) viewModel.startTimer()
                })
        }
    }
}

@Composable
fun AuthHeading(heading: String) {
    Text(
        text = heading,
        fontFamily = Rosario,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        color = Blue
    )
}
