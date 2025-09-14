package com.example.videoview;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.videoview.R;

public class MainActivity extends AppCompatActivity {
    VideoView simpleVideoView;
    MediaController mediaControls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);
        if (mediaControls == null) {
            mediaControls = new MediaController(MainActivity.this);
            mediaControls.setAnchorView(simpleVideoView);
        }
        simpleVideoView.setMediaController(mediaControls);
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" +
                getPackageName() + "/" +R.raw.flash));
        simpleVideoView.start();

        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                            @Override
          public void onCompletion(MediaPlayer mp) {
             Toast.makeText(getApplicationContext(), "Thank You...!!!", Toast.LENGTH_LONG).show();

               }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                                                       @Override
            public boolean onError(MediaPlayer mp, int what, int extra)
                 {
                      Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show();
                            return false;
                   }
       });
    }
}
