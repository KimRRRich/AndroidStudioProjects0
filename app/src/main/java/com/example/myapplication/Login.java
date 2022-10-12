package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;

public class Login extends AppCompatActivity {

//    TextView LabelView = null;


    TextView textView;
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    Date curDate = new Date(System.currentTimeMillis());
    String str= formatter.format(curDate);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView=(TextView) findViewById(R.id.TimeText);
        textView.setText(str);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.layout.main,menu);
//        //inflater.inflate(R.menu.activity_login_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        TextView label = (TextView)findViewById(R.id.label);
//
//        switch (item.getItemId()) {
//            case R.id.main_menu_0:
//                label.setText("打印，菜单ID：" + item.getItemId());
//                return true;
//            case R.id.main_menu_1:
//                label.setText("新建，菜单ID：" + item.getItemId());
//                return true;
//            case R.id.main_menu_2:
//                label.setText("邮件，菜单ID：" + item.getItemId());
//                return true;
//            case R.id.main_menu_3:
//                label.setText("设置，菜单ID：" + item.getItemId());
//                return true;
//            case R.id.main_menu_4:
//                label.setText("订阅，菜单ID：" + item.getItemId());
//                return true;
//            default:
//                return false;
//        }
//    }









}