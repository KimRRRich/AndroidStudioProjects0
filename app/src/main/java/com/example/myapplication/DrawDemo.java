package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class DrawDemo extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_draw_demo);
//        androidx.constraintlayout.widget.ConstraintLayout layout=(androidx.constraintlayout.widget.ConstraintLayout) findViewById(com.google.android.material.R.id.layout);
//        View1 view1=new View1(this);
//        layout.addView(view1);
//    }
//}
//
//class View1 extends View{
//    public View1(Context context){
//        super(context);
//    }
//    @Override
//    protected void onDraw(Canvas canvas){
//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        setLayerType(LAYER_TYPE_SOFTWARE,null);
//        paint.setShadowLayer(5,5,5,Color.rgb(90,90,90));
//        canvas.drawRect(60,120,300,375,paint);
//        paint.setTextSize(36);
//        canvas.drawText("杭电科大",265,265,paint);
//        float[]pos =new float[]{80,215,105,215,130,215,80,240,105,240,130,240};
//        canvas.drawPosText("很高兴见到你",pos,paint);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_demo);
        androidx.constraintlayout.widget.ConstraintLayout layout=(androidx.constraintlayout.widget.ConstraintLayout)findViewById(R.id.layout);
        View1 view1=new View1(this);
        layout.addView(view1);
    }
}
class  View1 extends View{
    public View1(Context context){
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        Paint paint1=new Paint();
        paint.setColor(Color.rgb(144 ,238 ,144));
        paint1.setColor(Color.WHITE);
        int round_x=550;
        int round_y=500;
        int r=300;
        //paint.setARGB(0,0,200,0);
//        paint.setStyle(Paint.Style.STROKE);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        //paint.setShadowLayer(5,5,5,Color.rgb(0,90,0));
        //canvas.drawRect(40,80,200,250,paint);
        canvas.drawCircle(round_x,round_y,r,paint);
        paint.setStrokeWidth(10);
        canvas.drawLine((int)(round_x-0.4*r),(int)(round_y-0.6*r),round_x-r+20,round_y-r-10,paint);
        canvas.drawLine((int)(round_x+0.4*r),(int)(round_y-0.6*r),round_x+r-20,round_y-r-10,paint);
        canvas.drawRect(round_x-r,400,round_x+r,900,paint1);
        canvas.drawCircle((int)(round_x-0.4*r),(int)(round_y-0.6*r),15,paint1);
        canvas.drawCircle((int)(round_x+0.4*r),(int)(round_y-0.6*r),15,paint1);
        canvas.drawRoundRect(round_x-r+5,round_y-70,round_x+r-5,round_y+500,30,30,paint);
        canvas.drawRoundRect(round_x-r-110,round_y-50,round_x-r-30,round_y+450,60,60,paint);
        canvas.drawRoundRect(round_x+r+30,round_y-50,round_x+r+110,round_y+450,60,60,paint);
        canvas.drawRoundRect(round_x-150,round_y-50,round_x-70,round_y+750,60,60,paint);
        canvas.drawRoundRect(round_x+70,round_y-50,round_x+150,round_y+750,60,60,paint);
        //canvas.drawLine(round_x,round_y,round_x-r,round_y-r,paint);
        //canvas.drawLine(round_x,round_y,round_x+r,round_y-r,paint);


        //paint.setShadowLayer(5,100,100,Color.rgb(0,90,0));
        //canvas.drawRect(40,80,200,250,paint);
//        super.onDraw(canvas);
        //paint.setTextSize(36);
        //canvas.drawText("电子科大",265,265,paint);
        //float[]pos =new float[]{80,215,105,215,130,215,80,240,105,240,130,240};
        //canvas.drawPosText("很高兴见到你",pos,paint);
    }
}