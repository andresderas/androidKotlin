package com.naldana.chatapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var messageEditText: EditText
    private lateinit var displayMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addEvents()
    }

    private fun addEvents() {
        val previewButton = findViewById<Button>(R.id.action_preview)
        val sendButton = findViewById<Button>(R.id.action_send)

        previewButton.setOnClickListener {
            displayMessageTextView.text = messageEditText.text.toString()
        }

        sendButton.setOnClickListener {
            // Se utiliza intent para mandar cosas a otra actividad
            val intent = Intent(this, DataActivity::class.java) //De donde y para adonde
            intent.putExtra(DataActivity.MESSAGE_KEY, messageEditText.text.toString())
            //Siempre se incluye el start
            startActivity(intent)
        }
    }

    private fun bind() {
        messageEditText = findViewById(R.id.message_text_input)
        displayMessageTextView = findViewById(R.id.display_message_text_view)
    }
}