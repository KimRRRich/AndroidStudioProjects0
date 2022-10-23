package com.example.myapplication;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

import androidx.core.app.ActivityCompat;

public class Location_test extends Service {
    private LocationManager lm;
    private MyLocationListener listener;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new MyLocationListener();
        // 注册监听位置服务
        // 给位置提供者设置条件
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String proveder = lm.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.requestLocationUpdates(proveder, 0, 0, (LocationListener) listener);
        //注册位置更新监听(最小时间间隔为5秒,最小距离间隔为5米)
        //lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, listener);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        // 取消监听位置服务
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lm.removeUpdates(listener);
        listener = null;
    }

    class MyLocationListener implements LocationListener{
        /**
         * 当位置改变的时候回调
         */
        @Override
        public void onLocationChanged(Location location) {
            String longitude = "j:" + location.getLongitude() + "\n";
            String latitude = "w:" + location.getLatitude() + "\n";
            String accuracy = "a" + location.getAccuracy() + "\n";
        }

        /**
         * 当状态发生改变的时候回调 开启--关闭 ；关闭--开启
         */
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
        }

        /**
         * 某一个位置提供者可以使用了
         */
        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        /**
         * 某一个位置提供者不可以使用了
         */
        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }
    }
}