package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    TextView textView,LabelView,Time_Text;
    Button button,GoToSchool,GoToStudent,GoToDoctor,GoToLogin,GoToTab,GoToKeyEvent,GoToTouchEvent,GoToDrawDemo,GoToIntent,SendMsg,SendMsg2,GoToSon1,SendMsgToSon,Thread_Button,Service_Button,StopService_Button,StartThread_Button;
    Button GoToSimpleMathService,GoToDataSaving,GoToInsideSaving,GoTONewPage;
    EditText account,TelNumber;
    DynamicReceiver dynamicReceiver=new DynamicReceiver();
    Handler handler;
    Handler HandlerFormMainToThread;


    final static int MENU_00 = Menu.FIRST;
    final static int MENU_01 = Menu.FIRST+1;
    final static int MENU_02 = Menu.FIRST+2;
    final static int MENU_03 = Menu.FIRST+3;
    final static int MENU_04 = Menu.FIRST+4;

    final static int CONTEXT_MENU_1 = Menu.FIRST;
    final static int CONTEXT_MENU_2 = Menu.FIRST+1;
    final static int CONTEXT_MENU_3 = Menu.FIRST+2;

    int SUBACTIVITY1 = 1;
    boolean isThreadWork=false;
    boolean isThreadStart=false;
    boolean isServiceStart=false;

    class DynamicReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg=intent.getStringExtra("Account");
            Toast.makeText(context,"???????????????????????????"+msg,Toast.LENGTH_SHORT).show();
        }
    }

    class WorkThread extends Thread{
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            HandlerFormMainToThread= new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    int ii=(int)msg.what;
                    System.out.println(ii);
                }
            };
            Looper.loop();
            System.out.println(Thread.currentThread().getName());
        }
    }

    Runnable backgroundWork=new Runnable() {
        @Override
        public void run() {
            while(true) {
                while (isThreadWork) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = handler.obtainMessage();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    Date date = new Date(System.currentTimeMillis());
                    msg.obj = simpleDateFormat.format(date).toString();
                    //Log.i("TimeThread:",simpleDateFormat.format(date).toString());
                    handler.sendMessage(msg);
                    System.out.println("Runable: " + Thread.currentThread().getName());
                    System.out.println("TimeThread: " +simpleDateFormat.format(date).toString() );

                }
            }
        }
    };




    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SUBACTIVITY1){
            String msg1=data.getStringExtra("NameText");
            String msg2=data.getStringExtra("Telnumber");
            Toast t=Toast.makeText(this,msg1,Toast.LENGTH_SHORT);
            t.show();
            account.setText(msg1);
            TelNumber.setText(msg2);

            //Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
            //Toast t=new Toast();
            //account.setText();
        }

    }

//    String serviceString= Context.LOCATION_SERVICE;
//    LocationManager locationManager=(LocationManager) getSystemService(serviceString);
//    String provider=LocationManager.GPS_PROVIDER;
    //Location location=locationManager.getLastKnownLocation(provider);



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        System.out.println(Thread.currentThread().getName());
        WorkThread workThread=new WorkThread();
        workThread.start();
        Thread workthread2=new Thread(backgroundWork);
        //workthread2.start();


        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("HDU","1-1 onCreate");

        Time_Text=(TextView)findViewById(R.id.Time_Text);
        LabelView=(TextView) findViewById(R.id.textView4);
        registerForContextMenu(LabelView);

        //textView = (TextView) findViewById(R.id.b01);
        button = (Button) findViewById(R.id.LoginButton);
        GoToSchool=(Button)findViewById(R.id.GoToSchool);
        GoToStudent=(Button) findViewById(R.id.StudentButton);
        GoToDoctor=(Button) findViewById(R.id.GoToDoctor);
        GoToLogin=(Button) findViewById(R.id.GoToLogin);
        GoToTab=(Button) findViewById(R.id.GoToTab);
        GoToKeyEvent=(Button) findViewById(R.id.GoToKeyEvent);
        GoToTouchEvent=(Button)findViewById(R.id.GoToTouchEvent);
        GoToDrawDemo=(Button) findViewById(R.id.GoToDrawDemo);
        GoToIntent=(Button)findViewById(R.id.GoToIntent);
        SendMsg=(Button)findViewById(R.id.SendMsg);
        SendMsg2=(Button)findViewById(R.id.sendMsg2);
        GoToSon1=(Button)findViewById(R.id.GoToSon1);
        SendMsgToSon=(Button)findViewById(R.id.SendMsgToSon);
        Thread_Button=(Button)findViewById(R.id.Thread_Button);
        Service_Button=(Button)findViewById(R.id.ServiceButton);
        StopService_Button=(Button)findViewById(R.id.CloseServeButton);
        StartThread_Button=findViewById(R.id.StartThread_Button);
        GoToSimpleMathService=findViewById(R.id.GoToSimpleMathService);
        GoToDataSaving=findViewById(R.id.DataSave_Button);
        GoToInsideSaving=findViewById(R.id.GoToInsideSaving);
        GoTONewPage=findViewById(R.id.GoToNewPage);
        account=(EditText)findViewById(R.id.Main_NameText);
        TelNumber=(EditText)findViewById(R.id.TelNumber);


        Message MessageFromMainToThread=new Message();
        MessageFromMainToThread.what=666;
        HandlerFormMainToThread.sendMessage(MessageFromMainToThread);

        IntentFilter filter=new IntentFilter();
        filter.addAction("com.example.jie.Broad");

        registerReceiver(dynamicReceiver,filter);
        final Intent MusicPlay=new Intent(MainActivity.this,PlayMusic.class);

////????????????????????????????????????????????????????????????????????????
//        ButtonListener buttonListener=new ButtonListener();
//        button.setOnClickListener(buttonListener);

////????????? ??????new???????????????
//        View.OnClickListener buttonListener = new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                textView.setText("????????????");
//            }
//        };
//         button.setOnClickListener(buttonListener);

        //????????????????????????
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("???????????????");
                Log.i("zx","666");
              Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
               startActivity(intent);
            }
        });

        GoToSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        GoToStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        GoToDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Doctor.class);
                startActivity(intent);
            }
        });

        GoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

        GoToTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Tab.class);
                startActivity(intent);
            }
        });

        GoToKeyEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,KeyEventTest.class);
                startActivity(intent);
            }
        });

        GoToTouchEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,TouchEventTest.class);
                startActivity(intent);
            }
        });
        GoToDrawDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,DrawDemo.class);
                startActivity(intent);
            }
        });

        GoToIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"??????????????????????????????",Toast.LENGTH_LONG).show();
                //Intent intent1 = new Intent(MainActivity.this, com.example.myapplication.Intent.class);
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("schemodemo://edu.hrbeu"));
                Intent intent3=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:19818519509"));
                startActivity(intent2);
            }
        });

        SendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String s1=account.getText().toString();
               float s2= 3.141592657f;
                Intent intent=new Intent();
                intent.setAction("com.example.jie.Broad");
                intent.putExtra("Account",s1);
                sendBroadcast(intent);
            }
        });

        SendMsg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=account.getText().toString();
                float s2= 3.141592657f;
                Intent intent=new Intent();
                intent.setAction("com.example.jie.Broad");
                intent.putExtra("Account",s1);
                sendBroadcast(intent);
            }
        });

        GoToSon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,son1.class);
                startActivityForResult(intent,SUBACTIVITY1);
            }
        });

        SendMsgToSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accout = account.getText().toString();
                String telnumber=TelNumber.getText().toString();
                Intent intent=new Intent(MainActivity.this,son2.class);
                intent.putExtra("Account",accout);
                intent.putExtra("TelNumber",telnumber);
                startActivity(intent);

            }
        });
        Thread_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    isThreadWork=false;
                    Toast t=Toast.makeText(MainActivity.this,"????????????",Toast.LENGTH_SHORT);
                    t.show();
            }
        });
        StartThread_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isThreadStart==false){
                    isThreadStart=true;
                    isThreadWork=true;
                    workthread2.start();
                    Toast t=Toast.makeText(MainActivity.this,"????????????",Toast.LENGTH_SHORT);
                    t.show();

                }else{
                    isThreadWork=true;
                }
            }
        });

        Service_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    isServiceStart=true;
                    startService(MusicPlay);
                    //Service_Button.setText("????????????");
            }
        });

        StopService_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isServiceStart=false;
                stopService(MusicPlay);
            }
        });

        GoToSimpleMathService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SimpleMath.class);
                startActivity(intent);
            }
        });


        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
            // TODO ???????????????????????????
                super.handleMessage(msg);

                String s=(String)msg.obj;
                Time_Text.setText(s);
            }
        };

        GoToDataSaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DataSaving.class);
                startActivity(intent);
            }
        });
        GoToInsideSaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,InsideSaving1.class);
                startActivity(intent);
            }
        });

        GoTONewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Newpage.class);
                startActivity(intent);
            }
        });


    }












//    //????????????????????????????????????
//    class ButtonListener implements View.OnClickListener{
//        //????????????
//        @Override
//        public void onClick(View v) {
//              textView.setText("????????????");
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        ?????????int?????????groupID????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//        ?????????int?????????item ID?????????????????????????????????????????????????????????????????????itemID????????????menu????????????????????????????????????????????????????????????item ID???????????????????????????????????????
////        ?????????int?????????orderID?????????????????????????????????????????????????????????0??????????????????????????????????????????add???????????????????????????
////        ?????????String?????????title??????????????????????????????????????????
//        menu.add(0,MENU_00,0,"??????");
//        menu.add(0,MENU_01,1,"??????");
//        menu.add(0,MENU_02,2,"??????");
//        menu.add(0,MENU_03,3,"??????");
//        menu.add(0,MENU_04,4,"??????");

//        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.menu1, menu);
//???????????????true???,????????????????????????????????????

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("??????????????????");
        System.out.println(String.valueOf(CONTEXT_MENU_1));
        menu.add(0, CONTEXT_MENU_1, 0,"????????????");
        menu.add(0, CONTEXT_MENU_2, 1,"????????????");
        menu.add(0, CONTEXT_MENU_3, 2,"???????????????");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){

            case CONTEXT_MENU_1:
                System.out.println(String.valueOf(item.getItemId()));
                LabelView.setText("????????????1");
                return true;
            case CONTEXT_MENU_2:
                LabelView.setText("????????????2");
                return true;
            case CONTEXT_MENU_3:
                LabelView.setText("????????????3");
                return true;
        }
        return false;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onStart(){
        super.onStart();
        Log.i("HDU","1-2 onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("HDU","1-3 onRestoreInstanceState");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("HDU","1-4 onResume()");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i("HDU","1-5 onSaveInstanceState()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("HDU","1-6 onRestart()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("HDU","1-7 onPause()");
        unregisterReceiver(dynamicReceiver);
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("HDU","1-8 onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("HDU","1-9 onDestroy()");
    }





}

