package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity {
    Spinner spinner;
    TextView displayText,nameText,numText,classText;
    String msg="";
    Button submitButton;
    CheckBox C,Java,Python;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spinner=(Spinner)findViewById(R.id.classText);
        displayText=(TextView)findViewById(R.id.textView6);
        nameText=(TextView)findViewById(R.id.nameTitle);
        numText=(TextView)findViewById(R.id.numText);
        submitButton=(Button)findViewById(R.id.submit);
        name=(EditText) findViewById(R.id.NameText);
        //classText=(TextView)findViewById(R.id.classText);


        List<String> spinnerList=new ArrayList<String>();
        spinnerList.add("数媒一班");
        spinnerList.add("数媒二班");
        spinnerList.add("工业设计");
        spinnerList.add("法学");
        spinnerList.add("产品设计");
        spinnerList.add("传播学");
        C=(CheckBox)findViewById(R.id.C);
        Java=(CheckBox)findViewById(R.id.Java);
        Python=(CheckBox)findViewById(R.id.Python);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,spinnerList);
        spinner.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg="";
                msg+="学生姓名："+name.getText()+"\n"+"学生学号："+numText.getText()+"\n"+"学生班级:"+spinner.getSelectedItem().toString()+"\n"+"学生感兴趣的课程：";
                if(C.isChecked()){
                    msg+="C/C++  ";
                }
                if(Java.isChecked()){
                    msg+="Java  ";
                }if(Python.isChecked()){
                    msg+="Python  ";
                }
                if(!C.isChecked()&&!Java.isChecked()&&!Python.isChecked()){
                    msg+="无";
                }

                displayText.setText(msg);
            }
        });


    }
}