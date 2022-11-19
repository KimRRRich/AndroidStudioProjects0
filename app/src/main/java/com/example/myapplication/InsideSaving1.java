package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InsideSaving1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_saving1);
        String File_Name="fileDemo.txt";
        try {
            FileInputStream fis=openFileInput(File_Name);
            try {
                byte[] readBytes=new byte[fis.available()];
                while(fis.read(readBytes)!=-1){

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}