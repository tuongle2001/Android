package com.example.listviewcoban

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var listView = findViewById<ListView>(R.id.listview)
//        var mangmonhoc : List<String> = listOf("IOS","ANDROID","PHP")
//        //lấy dữ liệu đỗ lên bản vẽ
//        //arrayadapter khởi tạo bản vẽ
//        listView.adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,mangmonhoc)

        var arraymonan :ArrayList<MonAn> = ArrayList()
        arraymonan.add(MonAn("Bánh mỳ Việt Nam",R.drawable.banhmi))
        arraymonan.add(MonAn("Chả giò",R.drawable.chagio))
        var listview= findViewById<ListView>(R.id.listview)
        listview.adapter = CustomAdapter(this@MainActivity,arraymonan)
    }
}