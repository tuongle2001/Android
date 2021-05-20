package com.example.vidu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Sv1: SinhVien = SinhVien("Tường Lee", "Sơn Tịnh",2003)
//        Sv1.Hoten= "Lê Văn Tường"
//        Sv1.Diachi ="Quảng Ngãi"
//        Sv1.namsinh=2001
//        Sv1.setHoten("Lê Văn Tường")
//        Sv1.setDiachi("T.p Quảng Ngãi")
//        Sv1.setNamsinh(1999)
        Log.d("AAA",Sv1.getHoten() +"-" + Sv1.getDiachi()+"-"+Sv1.getNamsinh())

        val ptien: PhuongTien= PhuongTien("Xe dap", "den", 2)
        Log.d("AAA","Phuong tien: "+ptien.ten+" Mau: "+ptien.mau)
    }
}