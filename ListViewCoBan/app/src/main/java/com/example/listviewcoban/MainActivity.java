package com.example.listviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    ArrayList<String> arrayCourse;

    Button btnThem;
    EditText edtMonHoc;
    Button btnCapNhat;
    int vitri=-1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView)findViewById(R.id.listviewMonHoc);
        arrayCourse = new ArrayList<>();

        btnThem =(Button)findViewById(R.id.buttonThem);
        edtMonHoc =(EditText)findViewById(R.id.editTextMonHoc);
        btnCapNhat =(Button)findViewById(R.id.buttonCapNhat);


//        arrayCourse = new ArrayAdapter(applicationContext, android.R.layout.simple_list_item_multiple_choice, resources.getStringArray(R.array.colorName))
//        listView?.adapter = arrayAdapter
//        listView?.choiceMode= ListView.CHOICE_MODE_MULTIPLE
//        listView?.onItemClickListener = this

        arrayCourse.add("PHP");
        arrayCourse.add("ANDROID");
        arrayCourse.add("CNPM");
        arrayCourse.add("HĐH");
        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, arrayCourse);
//        lvMonHoc.choiceMode= ListView.CHOICE_MODE_MULTIPLE;
        //this.lvMonHoc.setAdapter(adapter);


        lvMonHoc.setAdapter(adapter);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position trả về vị trí click trên listview->0
                Toast.makeText(MainActivity.this,arrayCourse.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,"Tường click" + position, Toast.LENGTH_LONG).show();
                arrayCourse.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMonHoc.setText(arrayCourse.get(position));
                vitri= position;
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(vitri,edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });










    }
}