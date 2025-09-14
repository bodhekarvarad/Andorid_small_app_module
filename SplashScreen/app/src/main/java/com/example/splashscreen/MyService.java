package com.example.splashscreen;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyService extends Service {
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        return null;//started service,if return with object of onBind method is bound service
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp=MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_RINGTONE_URI);
        mp.setLooping(true);
        mp.start();
        return flags;
    }
    public void onDestroy(){
        mp.stop();
    }

}
