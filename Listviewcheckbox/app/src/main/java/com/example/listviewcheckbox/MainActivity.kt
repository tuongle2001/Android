package com.example.listviewcheckbox

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var listView: ListView? = null
    private  var arrayAdapter:ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listView = findViewById(R.id.multiple_list_view)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_multiple_choice, resources.getStringArray(R.array.colorName))
        listView?.adapter = arrayAdapter
        listView?.choiceMode= ListView.CHOICE_MODE_MULTIPLE
        listView?.onItemClickListener = this

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String = parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext, "Color Name :$item", Toast.LENGTH_LONG).show()
    }



}