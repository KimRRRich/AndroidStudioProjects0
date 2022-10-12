package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends AppCompatActivity {
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);


        listView=(ListView) findViewById(R.id.Doctor);
        textView=(TextView) findViewById(R.id.DocterText);

        List<String> list2 = new ArrayList<String>();
        list2.add("博士");
        list2.add("硕士");
        list2.add("学士");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list2);
        listView.setAdapter(adapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // TODO Auto-generated method stub
                String msg = "父View："+adapterView.toString()+"\n"+ "子View："+view.toString()+"\n"+"位置："+String.valueOf(i)+"，ID："+String.valueOf(l);//arg2为行号，arg3为ID号
                textView.setText(msg);
            }
        });

    }
}