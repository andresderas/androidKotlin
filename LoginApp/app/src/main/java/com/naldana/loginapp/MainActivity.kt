package com.naldana.loginapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //Es importante agregar las librerias en gradle scripts,
    // en esta ocasion la de activity y fragment
    private val viewModel: MainViewModel by viewModels()
    private lateinit var userField: EditText
    private lateinit var passwordField: EditText
    private lateinit var displayData: TextView
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        // Asignando los valores guardados en el viewModel a los campos correspondiente
        userField.setText(viewModel.user) //No maneja .text por eso se utiliza .setText
        passwordField.setText(viewModel.password)
        displayData.text = getDisplayData()
        loginButton.setOnClickListener {
            viewModel.user = userField.text.toString() //Guardando lo escrito en el viewModel
            viewModel.password = passwordField.text.toString()
            displayData.text = getDisplayData() //Cuando cambien que lo muestre
        }
    }

    private fun bind() {
        userField = findViewById(R.id.text_user_input)
        passwordField = findViewById(R.id.text_password_input)
        loginButton = findViewById(R.id.action_login)
        displayData = findViewById(R.id.display_data)
    }

    //Funcion que obtiene ambos valores guardados en el viewModel y los une en un solo string
    fun getDisplayData() =
            " ${viewModel.user} , ${viewModel.password}"

}