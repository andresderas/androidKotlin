package com.naldana.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {


    private var _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    fun setMessage(message: String) {
        // Validaciones
        _message.value = message
    }

    init {
        _message.value = ""
    }

    var messageLowerCase = Transformations.map(message) { message ->
        message.toLowerCase(Locale.ROOT)
    }

    var messageToNumbers = Transformations.map(message) { message ->
        message.replace('A','4').replace('I','1')
            .replace('O','0').replace('E','3')
            .replace('S','5').replace('T','7')
            .replace('a','4').replace('i','1')
            .replace('o','0').replace('e','3')
            .replace('s','5').replace('t','7')
    }

}