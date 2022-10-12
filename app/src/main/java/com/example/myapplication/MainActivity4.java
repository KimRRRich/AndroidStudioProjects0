package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.os.Bundle;

public class MainActivity4 extends AppCompatActivity {
    TextView textView;
    RadioGroup radioGroup;
    RadioButton zju,hdu,zjut,ningbo,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView=(TextView) findViewById(R.id.textView3);
        radioGroup=(RadioGroup) findViewById(R.id.School);
        zju=(RadioButton) findViewById(R.id.zju);
        hdu=(RadioButton) findViewById(R.id.hdu);
        zjut=(RadioButton) findViewById(R.id.zjut);
        ningbo=(RadioButton) findViewById(R.id.ningbo);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectRadioBtn();
            }
        });
    }

    private void selectRadioBtn() {
        button = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        textView.setText("浙江省第一的大学是:" + button.getText());
    }

}