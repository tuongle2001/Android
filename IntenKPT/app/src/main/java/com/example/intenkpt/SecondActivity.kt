package com.example.intenkpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //nhận dữ liệu truyền từ intent
        val intent = intent
        val hoten: String? = intent.getStringExtra("data")
        val txtNoiDung= findViewById<TextView>(R.id.txtNoiDung)
        txtNoiDung.text = hoten
    }
}