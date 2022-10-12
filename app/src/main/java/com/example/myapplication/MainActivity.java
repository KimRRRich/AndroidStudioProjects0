package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {

    TextView textView,LabelView;
    Button button,GoToSchool,GoToStudent,GoToDoctor,GoToLogin,GoToTab,GoToKeyEvent,GoToTouchEvent,GoToDrawDemo;

    final static int MENU_00 = Menu.FIRST;
    final static int MENU_01 = Menu.FIRST+1;
    final static int MENU_02 = Menu.FIRST+2;
    final static int MENU_03 = Menu.FIRST+3;
    final static int MENU_04 = Menu.FIRST+4;

    final static int CONTEXT_MENU_1 = Menu.FIRST;
    final static int CONTEXT_MENU_2 = Menu.FIRST+1;
    final static int CONTEXT_MENU_3 = Menu.FIRST+2;

//    String serviceString= Context.LOCATION_SERVICE;
//    LocationManager locationManager=(LocationManager) getSystemService(serviceString);
//    String provider=LocationManager.GPS_PROVIDER;
    //Location location=locationManager.getLastKnownLocation(provider);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("HDU","1-1 onCreate");

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
////方法一，先生成一个类，再实例化类，再注册到监听器
//        ButtonListener buttonListener=new ButtonListener();
//        button.setOnClickListener(buttonListener);

////方法二 直接new一个监听器
//        View.OnClickListener buttonListener = new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                textView.setText("测试成功");
//            }
//        };
//         button.setOnClickListener(buttonListener);

        //方法三，直接写在
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("登录成功！");
                Log.i("zx","666");
              Toast.makeText(MainActivity.this,"成功切换到第二个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
               startActivity(intent);
            }
        });

        GoToSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        GoToStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        GoToDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Doctor.class);
                startActivity(intent);
            }
        });

        GoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

        GoToTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Tab.class);
                startActivity(intent);
            }
        });

        GoToKeyEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,KeyEventTest.class);
                startActivity(intent);
            }
        });

        GoToTouchEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,TouchEventTest.class);
                startActivity(intent);
            }
        });
        GoToDrawDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zx","666");
                //Toast.makeText(MainActivity.this,"成功切换到第四个界面",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,DrawDemo.class);
                startActivity(intent);
            }
        });




    }

//    //方法一中的创建一个内部类
//    class ButtonListener implements View.OnClickListener{
//        //手动重载
//        @Override
//        public void onClick(View v) {
//              textView.setText("测试成功");
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        第一个int类型的groupID参数，代表的是组概念，你可以将几个菜单项归为一组，以便更好的以组的方式管理你的菜单按钮。
//        第二个int类型的item ID参数，代表的是项目编号。这个参数非常重要，一个itemID对应一个menu中的选项。在后面使用菜单的时候，就靠这个item ID来判断你使用的是哪个选项。
////        第三个int类型的orderID参数，代表的是菜单项的显示顺序。默认是0，表示菜单的显示顺序就是按照add的显示顺序来显示。
////        第四个String类型的title参数，表示选项中显示的文字。
//        menu.add(0,MENU_00,0,"打印");
//        menu.add(0,MENU_01,1,"新建");
//        menu.add(0,MENU_02,2,"邮件");
//        menu.add(0,MENU_03,3,"设置");
//        menu.add(0,MENU_04,4,"订阅");

//        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.menu1, menu);
//返回值为“true”,表示菜单可见，即显示菜单

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
        menu.setHeaderTitle("快捷菜单标题");
        System.out.println(String.valueOf(CONTEXT_MENU_1));
        menu.add(0, CONTEXT_MENU_1, 0,"访客模式");
        menu.add(0, CONTEXT_MENU_2, 1,"会员模式");
        menu.add(0, CONTEXT_MENU_3, 2,"管理员模式");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){

            case CONTEXT_MENU_1:
                System.out.println(String.valueOf(item.getItemId()));
                LabelView.setText("菜单子项1");
                return true;
            case CONTEXT_MENU_2:
                LabelView.setText("菜单子项2");
                return true;
            case CONTEXT_MENU_3:
                LabelView.setText("菜单子项3");
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

