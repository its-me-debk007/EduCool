package `in`.educool.compose.presentation.viewmodel.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerifyOtpViewModel @Inject constructor() : ViewModel() {
    private var _timer = mutableStateOf(30)
    val timer: State<Int> = _timer

    init {
        startTimer()
    }

    fun startTimer() {
        _timer.value = 30

        viewModelScope.launch {
            while (timer.value != 0) {
                delay(1000L)
                _timer.value--
            }
        }
    }
}
