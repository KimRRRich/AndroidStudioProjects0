package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.Touch;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TouchEventTest extends AppCompatActivity {
    TextView Touch_area,history_label,event_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event_test);
        Touch_area = (TextView) findViewById(R.id.Touch_area);
        history_label=(TextView) findViewById(R.id.history_label);
        event_label=(TextView) findViewById(R.id.event_label);
        Touch_area.setText("触摸屏幕试试：");

        Touch_area.setOnTouchListener(new View.OnTouchListener() {
            //@Override
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action){
                    case(MotionEvent.ACTION_DOWN):
                        Display("ACTION_DOWN",motionEvent);
                        break;
                    case(MotionEvent.ACTION_UP):
                        int historySize=ProcessHistory(motionEvent);
                        history_label.setText("历史数据量"+historySize);
                        Display("ACTION_UP",motionEvent);
                        break;
                    case (MotionEvent.ACTION_MOVE):
                        Display("ACTION_MOVE",motionEvent);
                        break;
                    }

                return false;
                }
        });
    }

    private  void Display(String eventType,MotionEvent event){
        int x=(int)event.getX();
        int y=(int)event.getY();
        float pressure=event.getPressure();
        float size=event.getSize();
        int RawX=(int)event.getRawX();
        int RawY=(int)event.getRawY();

        String msg="";
        msg+="事件类型："+eventType+"\n";
        msg+="相对坐标："+String.valueOf(x)+","+String.valueOf(y)+"\n";
        msg+="绝对坐标："+String.valueOf(RawX)+","+String.valueOf(RawY)+"\n";
        msg+="触点压力："+String.valueOf(pressure)+",    ";
        msg+="触点尺寸："+String.valueOf(size)+"\n";
        event_label.setText(msg);
        Toast.makeText(TouchEventTest.this,"屏幕触摸位置：("+RawX+","+RawY+")",Toast.LENGTH_LONG).show();
    }

    private int ProcessHistory(MotionEvent event){
        int historySize=event.getHistorySize();
        for(int i=0;i<historySize;i++){
            long time=event.getHistoricalEventTime(i);
            float pressure = event.getHistoricalPressure(i);
            float x=event.getHistoricalX(i);
            float y=event.getHistoricalY(i);
            float size=event.getHistoricalSize(i);
        }
        return historySize;
    }
}