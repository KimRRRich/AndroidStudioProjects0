package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class son2 extends AppCompatActivity {

    EditText NameText,TelText;
    Button BackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son2);
        NameText=(EditText) findViewById(R.id.son2_name);
        TelText=(EditText) findViewById(R.id.son2_telnumber);
        BackToMain=(Button)findViewById(R.id.BackToMain);

        Intent intent=getIntent();
        String account=intent.getStringExtra("Account");
        String telnumber=intent.getStringExtra("TelNumber");
        NameText.setText(account);
        TelText.setText(telnumber);


        BackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(son2.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }


}