package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataSaving extends AppCompatActivity {
    EditText NameValue,AgeValue,HeightValue;
    Button Saving_Button,GetData_Button,GoToLoginButton;
    public static int MODE= MODE_PRIVATE;
    public static final String PREFERENCE_NAME="SaveSetting";
    //SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_saving);
        NameValue=findViewById(R.id.DataSaving_NameValue);
        AgeValue=findViewById(R.id.DataSaving_AgeValue);
        HeightValue=findViewById(R.id.DataSaving_HeightValue);
        Saving_Button=findViewById(R.id.Saving_Button);
        GetData_Button=findViewById(R.id.GetData_Button);
        GoToLoginButton=findViewById(R.id.GoToLoginButton);
        SharedPreferences sharedPreferences=getSharedPreferences(PREFERENCE_NAME,MODE);


        Saving_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("Name",NameValue.getText().toString());
                editor.putInt("Age",Integer.parseInt(AgeValue.getText().toString()));
                editor.putFloat("Height",Float.parseFloat(HeightValue.getText().toString()));
                editor.commit();
                Toast.makeText(DataSaving.this,"Committed",Toast.LENGTH_SHORT).show();

            }
        });

        GetData_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=sharedPreferences.getString("Name","DefaultName");
                int age=sharedPreferences.getInt("Age",20);
                float height=sharedPreferences.getFloat("Height",1.7f);
                NameValue.setText(name);
                AgeValue.setText(String.valueOf(age));
                HeightValue.setText(String.valueOf(height));
                Toast.makeText(DataSaving.this,"GetData",Toast.LENGTH_SHORT).show();
            }
        });
        GoToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DataSaving.this,SharedPreferences_Login.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        editor.putString("Name",NameValue.getText().toString());
//        editor.putInt("Age",Integer.parseInt(AgeValue.getText().toString()));
//        editor.putFloat("Height",Float.parseFloat(HeightValue.getText().toString()));
//        editor.commit();
//        Toast.makeText(DataSaving.this,"Committed",Toast.LENGTH_SHORT).show();
//        //saveSharedPreferences();
//    }
}