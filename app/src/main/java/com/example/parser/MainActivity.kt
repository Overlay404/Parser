    package com.example.parser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.jsoup.Jsoup
import org.jsoup.nodes.*
import org.jsoup.select.Elements
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textInWeb = ""
        val text: TextView = findViewById(R.id.text)
        val btn: Button = findViewById(R.id.button)
        val intent = Intent(this, Settings::class.java)
        btn.setOnClickListener{
            startActivity(intent)
        }
        val urlAddress = getIntent().getSerializableExtra("urlAddress")
        val cssQuery = getIntent().getSerializableExtra("cssQuery")
        Log.d("!!!", urlAddress.toString())
        if(urlAddress != null || cssQuery != null) {
            GlobalScope.launch {
                val doc: Document = Jsoup.connect(urlAddress as String)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get()
                val element: Elements = doc.select(cssQuery as String)
                for (elem in element) {
                    textInWeb += elem.text() + "\n"
                }
            }
        }else{
            Toast.makeText(this, "Не заполнены поля URL или cssQuery в разделе настройки", Toast.LENGTH_SHORT).show()
        }
        Thread.sleep(1000L)
        text.text = textInWeb;
    }
}
