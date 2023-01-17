package `in`.educool.compose.presentation.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import `in`.educool.compose.ui.theme.Blue
import `in`.educool.compose.ui.theme.Gray
import `in`.educool.compose.ui.theme.ReemKufi
import `in`.educool.compose.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProfileDialog(isTeacher: Boolean, showDialog: Boolean, onDismiss: () -> Unit) {
    if (!showDialog) return

    val scrollState = rememberScrollState()
    var textFieldWidth by remember { mutableStateOf(-1)}

    var genderDropDown by remember { mutableStateOf(false) }
    var gender by remember { mutableStateOf("") }

    var departmentDropDown by remember { mutableStateOf(false) }

    Dialog(
        onDismissRequest = onDismiss, properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        Surface(color = Color.White, shape = RoundedCornerShape(24.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(scrollState)
            ) {

                Text(
                    text = if (isTeacher) "Teacher" else "Student",
                    fontFamily = ReemKufi,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Upload  a Profile Picture", fontFamily = ReemKufi, color = Blue)

                Image(
                    painter = painterResource(id = `in`.educool.compose.R.drawable.user),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(96.dp)
                        .align(CenterHorizontally)
                )

                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = Yellow,
                    elevation = FloatingActionButtonDefaults.elevation(4.dp),
                    modifier = Modifier
                        .offset(x = 32.dp, y = (-20).dp)
                        .size(32.dp)
                        .align(CenterHorizontally)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Choose Image"
                    )
                }

                Text(text = "Gender", fontFamily = ReemKufi, color = Blue)

                Spacer(modifier = Modifier.height(2.dp))

                OutlinedTextField(
                    value = gender,
                    onValueChange = {},
                    readOnly = true,
                    placeholder = { Text(text = "Gender", color = Gray, fontFamily = ReemKufi) },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null,
                            modifier = Modifier.clickable { genderDropDown = !genderDropDown })
                    },
                    modifier = Modifier.onGloballyPositioned { textFieldWidth = it.size.width }
                )

                DropdownMenu(
                    expanded = genderDropDown,
                    onDismissRequest = { genderDropDown = false },
                    modifier = Modifier.width(textFieldWidth.dp)
                ) {

                    DropdownMenuItem(onClick = {
                        gender = "Male"
                        genderDropDown = false
                    }, text = { Text(text = "Male") })

                    DropdownMenuItem(
                        onClick = {
                            gender = "Female"
                            genderDropDown = false
                        },
                        text = { Text(text = "Female") })
                }
            }
        }
    }
}
