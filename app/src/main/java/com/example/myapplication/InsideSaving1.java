package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InsideSaving1 extends AppCompatActivity {
    EditText Account,Password;
    String FILE_NAME1="Account.txt";
    String FILE_NAME2="Password.txt";
    Button InsideWrite,GoToInsideSavingRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_saving1);
        Account=findViewById(R.id.InsideSaving_Account);
        Password=findViewById(R.id.InsideSaving_Password);
        InsideWrite=findViewById(R.id.InsideSaving_WriteButton);
        GoToInsideSavingRead=findViewById(R.id.InsideSaving2_button);

        GoToInsideSavingRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.content.Intent intent=new Intent(InsideSaving1.this,InsideSaving2.class);
                startActivity(intent);
            }
        });


        InsideWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=Account.getText().toString();
                String password=Password.getText().toString();
                FileOutputStream account_fos=null;
                FileOutputStream passwordt_fos=null;

                try {
                    account_fos=openFileOutput(FILE_NAME1,MODE_PRIVATE);
                    passwordt_fos=openFileOutput(FILE_NAME2,MODE_PRIVATE);
                    try {
                        account_fos.write(account.getBytes());
                        passwordt_fos.write(password.getBytes());
                        account_fos.flush();
                        passwordt_fos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        Toast.makeText(InsideSaving1.this,"fos关闭成功",Toast.LENGTH_SHORT).show();
                        account_fos.close();
                        passwordt_fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}