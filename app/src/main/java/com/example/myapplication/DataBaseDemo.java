package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataBaseDemo extends AppCompatActivity {
    Button insertButton,deleteButton,updateButton,quertButton,showDatabase;
    TextView databaseValue;
    EditText ID, Name,Sex,Department,Salary;
    SQLiteDatabase db_read,db_write;
    SQLiteOpenHelper helper=new SQLiteOpenHelper(DataBaseDemo.this,"test1.db",null,1) {
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table staff(id int, name varchar(20),sex varchar(2),department varchar(30),salary float)");
            Toast.makeText(DataBaseDemo.this,"数据库创建成功",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_demo);
        insertButton=findViewById(R.id.insertButton);
        deleteButton=findViewById(R.id.deleteButton);
        updateButton=findViewById(R.id.updateButton);
        quertButton=findViewById(R.id.quertButton);
        showDatabase=findViewById(R.id.ShowDatabase);
        ID=findViewById(R.id.DataBaseIDValue);
        Name=findViewById(R.id.DataBaseNameValue);
        Sex=findViewById(R.id.DataBaseSexValue);
        Department=findViewById(R.id.DataBaseDepartmentValue);
        Salary=findViewById(R.id.DataBaseSalaryValue);
        databaseValue=findViewById(R.id.DataBaseValue);

        db_read=helper.getReadableDatabase();
        db_write=helper.getWritableDatabase();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db_write=helper.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put("id",Integer.parseInt(ID.getText().toString()));
                contentValues.put("name", Name.getText().toString());
                contentValues.put("sex", Sex.getText().toString());
                contentValues.put("department", Department.getText().toString());
                contentValues.put("salary", Float.parseFloat(Salary.getText().toString()));

                db_write.insert("staff",null,contentValues);
                Toast.makeText(DataBaseDemo.this,"插入成功",Toast.LENGTH_SHORT).show();
            }
        });

        showDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg="";
                Cursor cursor=db_read.query("staff",new String[]{"id","name","sex","department","salary"},null,null,null,null,null);
                while(cursor.moveToNext()){
                    String idString=cursor.getString(cursor.getColumnIndexOrThrow("id"));
                    String nameString=cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    String sexString=cursor.getString(cursor.getColumnIndexOrThrow("sex"));
                    String departmentString=cursor.getString(cursor.getColumnIndexOrThrow("department"));
                    String salaryString=cursor.getString(cursor.getColumnIndexOrThrow("salary"));
                    msg=msg+"\n"+"id："+idString+"  姓名："+nameString+"  性别："+sexString+"  部门："+departmentString+"  薪水："+salaryString+" ";
                }
                databaseValue.setText(msg);
            }
        });



    }
}