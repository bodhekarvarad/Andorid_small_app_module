package com.example.bindservice;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {
    IBinder BoundService=new MyService1();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return BoundService;

    }

    public String GetTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("HH:MM:SS   DD/MM/YYYY", Locale.ENGLISH);

        return sdf.format(new Date());


    }

    public class MyService1 extends Binder {
        MyService getService()
        {
            return MyService.this;
        }

    }

}