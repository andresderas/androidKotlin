package com.naldana.loginapp

import androidx.lifecycle.ViewModel

//El view model sera el encargado de modelar los datos que salen de la actividad
class MainViewModel : ViewModel() {
    var user: String = ""
    var password: String = ""
}