package com.example.parser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val backButton: Button = findViewById(R.id.backButton)
        val urlAddress:EditText = findViewById(R.id.urlAddress)
        val cssQuery: EditText = findViewById(R.id.cssQuery)

        val intent = Intent(this,MainActivity::class.java)
        backButton.setOnClickListener{
            intent.putExtra("urlAddress", urlAddress.text.toString())
            intent.putExtra("cssQuery", cssQuery.text.toString())
            startActivity(intent)
        }
    }
}