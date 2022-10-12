package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    Button back_button;
    Spinner spinner;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("HDU","2-1 onCreate");
        back_button=(Button)  findViewById(R.id.back_button);
        View.OnClickListener buttonListener =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_button.setText("成功！");
                Toast.makeText(MainActivity2.this,"成功进入第二个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);

            }
        };
        back_button.setOnClickListener(buttonListener);



        spinner=(Spinner)findViewById(R.id.spinner);
        List<String> spinnerList=new ArrayList<String>();
        spinnerList.add("浙江省");
        spinnerList.add("北京市");
        spinnerList.add("江苏省");
        spinnerList.add("上海市");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,spinnerList);
        spinner.setAdapter(adapter);

        listView = (ListView) findViewById(R.id.listView);
        List<String> list2 = new ArrayList<String>();
        list2.add("国家");
        list2.add("省");
        list2.add("市");
        list2.add("乡镇");
        list2.add("村");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list2);
        listView.setAdapter(adapter2);


    }

    @Override
    protected void onStart(){
        super.onStart();
     Log.i("HDU","2-2 onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("HDU","2-3 onRestoreInstanceState");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("HDU","2-4 onResume()");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i("HDU","2-5 onSaveInstanceState()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("HDU","2-6 onRestart()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("HDU","2-7 onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("HDU","2-8 onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("HDU", "2-9 onDestroy()");
    }
    }