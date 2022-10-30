package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class SimpleMathService extends Service {
    public class LocalBinder extends Binder{
        SimpleMathService getService(){
            return SimpleMathService.this;
        }
    }

    public SimpleMathService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "本地绑定：SimpleMathService", Toast.LENGTH_SHORT).show();
        final IBinder mBinder = new LocalBinder();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "解除绑定：SimpleMathService", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    public int intCompare(int a,int b){
        if(a>b) return a;
        else return b;
    }

}