package com.example.ungdungbetoanhoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var linearLayout =findViewById<LinearLayout>(R.id.linearlayout)

        var buttonCong= findViewById<Button>(R.id.buttoncong)
        var buttonTru= findViewById<Button>(R.id.buttontru)
        var buttonNhan= findViewById<Button>(R.id.buttonnhan)
        var buttonChia= findViewById<Button>(R.id.buttonchia)
        var edittextThu1=findViewById<EditText>(R.id.edittextthu1)
        var edittextThu2=findViewById<EditText>(R.id.edittextthu2)
        var textviewKetqua=findViewById<TextView>(R.id.textviewketqua)
        buttonCong.setOnClickListener {
            var sothu1: Int= (edittextThu1.text.toString()).toInt()
            var sothu2: Int= (edittextThu2.text.toString()).toInt()
            var ketqua =sothu1+sothu2
            textviewKetqua.text =ketqua.toString()
        }
        buttonTru.setOnClickListener {
            var sothu1: Int= (edittextThu1.text.toString()).toInt()
            var sothu2: Int= (edittextThu2.text.toString()).toInt()
            var ketqua =sothu1 - sothu2
            textviewKetqua.text =ketqua.toString()
        }
        buttonNhan.setOnClickListener {
            var sothu1: Int= (edittextThu1.text.toString()).toInt()
            var sothu2: Int= (edittextThu2.text.toString()).toInt()
            var ketqua =sothu1 * sothu2
            textviewKetqua.text =ketqua.toString()
        }
        buttonChia.setOnClickListener {
            var sothu1: Int= (edittextThu1.text.toString()).toInt()
            var sothu2: Int= (edittextThu2.text.toString()).toInt()
            var ketqua =sothu1 / sothu2
            textviewKetqua.text =ketqua.toString()
        }




    }
}