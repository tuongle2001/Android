package com.example.intenkpt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var buttonIntent = findViewById<Button>(R.id.buttonIntent)
        buttonIntent.setOnClickListener(){
            var intent: Intent= Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("data","Tường Lê")//truyền chuỗi
            startActivity(intent)
        }
    }
}