package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InsideSaving2 extends AppCompatActivity {
    TextView Account,Password;
    Button Read_Button;
    String FILE_NAME1="Account.txt";
    String FILE_NAME2="Password.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_saving2);
        Account=findViewById(R.id.InsideSaving2Account);
        Password=findViewById(R.id.InsideSaving2Password);
        Read_Button=findViewById(R.id.InsideSaving_button);

        Read_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream account_fis=null;
                FileInputStream password_fis=null;
                try {
                    account_fis=openFileInput(FILE_NAME1);
                    password_fis=openFileInput(FILE_NAME2);
                    try {
                        byte[] AccountReadBytes=new byte[account_fis.available()];
                        byte[] PasswordReadBytes=new byte[password_fis.available()];

                        while(account_fis.read(AccountReadBytes)!=-1){
                            String text=new String(AccountReadBytes);
                            Account.setText(text);
                        }
                        while(password_fis.read(PasswordReadBytes)!=-1){
                            String text=new String(PasswordReadBytes);
                            Password.setText(text);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}