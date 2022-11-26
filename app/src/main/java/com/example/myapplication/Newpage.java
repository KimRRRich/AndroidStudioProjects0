package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Newpage extends AppCompatActivity {
    Button GoToResourceFile,GoToDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage);
        GoToResourceFile=findViewById(R.id.GoToResourceDemo);
        GoToDataBase=findViewById(R.id.GoToDataBase);

        GoToResourceFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new android.content.Intent(Newpage.this,ReadResourceFile.class);
                startActivity(intent);
            }
        });

        GoToDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Newpage.this,DataBaseDemo.class);
                startActivity(intent);
            }
        });
    }
}