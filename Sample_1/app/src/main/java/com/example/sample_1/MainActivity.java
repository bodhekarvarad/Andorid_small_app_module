package com.example.sample_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.Menu;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {
    VideoView video;
    MediaController mc;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        video = findViewById(R.id.videoview);
        mc = new MediaController(this);
        mc.setAnchorView(video);
        uri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + "");
        video.setMediaController(mc);
        video.setVideoURI(uri);
        video.requestFocus();
        video.start();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);

        return true;

    }
}
