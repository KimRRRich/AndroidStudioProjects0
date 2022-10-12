package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class KeyEventTest extends AppCompatActivity {

    /** Called when the activity is first created. */
    CheckBox checkBox;
    TextView labelView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_event_test);

        EditText entryText = (EditText)findViewById(R.id.entry);
        checkBox = (CheckBox)findViewById(R.id.block);
        labelView = (TextView)findViewById(R.id.label);

//		第1行代码是设置控件的按键事件监听器
        entryText.setOnKeyListener(new OnKeyListener(){
            @Override

//			第3行代码的onKey ()函数中的参数,第1个参数view表示产生按键事件的界面控件
//			第2个参数keyCode表示按键代码;第3个参数keyEvent则包含了事件的详细信息，如按键的重复次数、硬件编码和按键标志等
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//	第4行代码用来获取功能键状态。功能键包括左Alt键、右Alt键和Shift键，当这三个功能键被按下时，功能键代码metaState值分别为18、34和65；但没有功能键被按下时，功能键代码metaState值分别为0
                int metaState = keyEvent.getMetaState();
                int unicodeChar = keyEvent.getUnicodeChar();//获取了按键的Unicode值，
                String msg = "";
//				获取了按键动作，0表示按下按键，1表示抬起按键。
                msg +="按键动作:" + String.valueOf(keyEvent.getAction())+"\n";
                msg +="按键代码:" + String.valueOf(keyCode)+"\n";
                msg +="按键字符:" + (char)unicodeChar+"\n";
                msg +="UNICODE:" + String.valueOf(unicodeChar)+"\n";
                msg +="重复次数:" + String.valueOf(keyEvent.getRepeatCount())+"\n";
//	代码获取按键的重复次数，但按键被长时间按下时，则会产生这个属性值
                msg +="功能键状态:" + String.valueOf(metaState)+"\n";
                msg +="硬件编码:" + String.valueOf(keyEvent.getScanCode())+"\n";
                msg +="按键标志:" + String.valueOf(keyEvent.getFlags())+"\n";
                labelView.setText(msg);

                if (checkBox.isChecked())
                    return true;
                else
                    return false;
            }
        });
    }
}