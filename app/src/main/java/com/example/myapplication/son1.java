package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class son1 extends AppCompatActivity {
    Button Commit,Quit;
    EditText NameText,TelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son1);
        Commit=(Button) findViewById(R.id.Commit);
        NameText=(EditText)findViewById(R.id.TelName);
        TelText=(EditText)findViewById(R.id.TelName1);
        Quit=findViewById(R.id.Quit);



        Commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri data=Uri.parse("tel:13735350023");
                Intent result=new Intent(null,data);
                String msg1=NameText.getText().toString();
                String msg2=TelText.getText().toString();
                result.putExtra("NameText",msg1);
                result.putExtra("Telnumber",msg2);
                setResult(Activity.RESULT_OK,result);
                finish();
            }
        });

        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(son1.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}