package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SimpleMath extends AppCompatActivity {
    Button BindService_Button,unBindService_Button, Calculate_Button;
    TextView Display_Text,RandomValue;
    SimpleMathService mathService;
    Random rand=new Random();

    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mathService=((SimpleMathService.LocalBinder)iBinder).getService();
            //Toast t1=Toast.makeText(SimpleMath.this,"绑定成功",Toast.LENGTH_SHORT);
            //t1.show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mathService=null;
            //Toast t2=Toast.makeText(SimpleMath.this,"解除绑定",Toast.LENGTH_SHORT);
            //t2.show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_math);

        BindService_Button=findViewById(R.id.BindService_Button);
        unBindService_Button=findViewById(R.id.unBindService_Button);
        Calculate_Button=findViewById(R.id.Calculate_Button);
        Display_Text=findViewById(R.id.Display_Text);
        RandomValue=findViewById(R.id.RandomValue);

        BindService_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent serviceIntent=new Intent(SimpleMath.this,SimpleMathService.class);
                bindService(serviceIntent,mConnection, Context.BIND_AUTO_CREATE);
            }
        });

        unBindService_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mathService==null){
                    Toast t3=Toast.makeText(SimpleMath.this,"mathService=null!!",Toast.LENGTH_SHORT);
                    t3.show();
                }
                else{
                    Toast t4=Toast.makeText(SimpleMath.this,"Trying to unbindService!!",Toast.LENGTH_SHORT);
                    t4.show();
                    unbindService(mConnection);
                }
            }
        });

        Calculate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=rand.nextInt(100);
                int b= rand.nextInt(100);
                RandomValue.setText("a:"+a+"   b:"+b);

                if(mathService==null){
                    Toast.makeText(SimpleMath.this,"mathService=null!!",Toast.LENGTH_SHORT).show();
                }else{
                    int bigger=mathService.intCompare(a,b);
                    Display_Text.setText("the bigger one is "+bigger);
                }

            }
        });

    }
}