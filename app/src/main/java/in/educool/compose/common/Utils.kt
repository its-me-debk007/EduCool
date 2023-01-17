package `in`.educool.compose.common

import android.util.Patterns

fun String.isValidEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()
