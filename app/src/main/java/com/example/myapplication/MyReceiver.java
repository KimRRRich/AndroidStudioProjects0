package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = new String();
        msg=intent.getStringExtra("Account");
        Toast toast=Toast.makeText(context,"账号："+msg,Toast.LENGTH_SHORT);
        toast.show();
    }
}