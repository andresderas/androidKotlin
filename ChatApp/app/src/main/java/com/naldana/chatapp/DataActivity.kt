package com.naldana.chatapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val messageTextView = findViewById<TextView>(R.id.display_message_text_view)

        // Aqui se esta recibiendo el mensaje desde la otra actividad
        val message = intent.extras?.getString(MESSAGE_KEY) // El mensaje viene en extras
        messageTextView.text =
            if (message.isNullOrEmpty()) getString(R.string.empty_message) else message
    }

    // Se crea un companion object para evitar errores
    companion object {
        const val MESSAGE_KEY = "MESSAGE_KEY"
    }
}