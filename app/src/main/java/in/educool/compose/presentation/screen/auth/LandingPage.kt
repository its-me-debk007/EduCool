package `in`.educool.compose.presentation.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.educool.compose.R
import `in`.educool.compose.ui.theme.Gray
import `in`.educool.compose.ui.theme.ReemKufi
import `in`.educool.compose.ui.theme.Roboto
import `in`.educool.compose.ui.theme.RubikMonoOne

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LandingPage() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        HeadingAndButtons(modifier = Modifier.offset(y = (-120).dp))
    }
}

@Composable
fun HeadingAndButtons(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 24.dp)) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontFamily = RubikMonoOne,
            fontSize = 30.sp,
        )

        Text(
            text = stringResource(id = R.string.landing_screen_text),
            fontFamily = Roboto,
            fontSize = 19.sp,
            color = Gray,
            modifier = Modifier.padding(top = 8.dp)
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Text(
                text = "Sign Up",
                fontFamily = ReemKufi,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = "Log In",
                fontFamily = ReemKufi,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}
