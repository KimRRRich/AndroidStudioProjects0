package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferences_Login extends AppCompatActivity {
    Button SharedPreferences_GetDataButton;
    EditText Name,Age,Height;
    public static int MODE= MODE_PRIVATE;
    public static final String PREFERENCE_NAME="SaveSetting";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_login);
        SharedPreferences_GetDataButton=findViewById(R.id.SharedPreferences_GetDataButton);
        Name=findViewById(R.id.SharedPreferences_NameValue);
        Age=findViewById(R.id.SharedPreferences_AgeValue);
        Height=findViewById(R.id.SharedPreferences_HeightValue);
        SharedPreferences sharedPreferences=getSharedPreferences(PREFERENCE_NAME,MODE);
        SharedPreferences_GetDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=sharedPreferences.getString("Name","DefaultName");
                int age=sharedPreferences.getInt("Age",20);
                float height=sharedPreferences.getFloat("Height",1.7f);
                Name.setText(name);
                Age.setText(String.valueOf(age));
                Height.setText(String.valueOf(height));
                Toast.makeText(SharedPreferences_Login.this,"GetData",Toast.LENGTH_SHORT).show();
            }
        });
    }


}