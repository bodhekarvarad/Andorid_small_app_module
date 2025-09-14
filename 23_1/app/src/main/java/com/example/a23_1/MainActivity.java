package com.example.a23_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import android.Manifest;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int MICROPHONE_PERMISSION_CODE = 1;
    private static final String RECORDING_FILE_NAME = "testingRecording.mp3"; // Define the file name here

    MediaPlayer mediaR;
    MediaPlayer mediaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isMicrophonePresent()) {
            getMicrophonePermission();
        }
    }

    private void getMicrophonePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, MICROPHONE_PERMISSION_CODE);
        }
    }

    private boolean isMicrophonePresent() {
        return this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }

    public void startRecording(View view) {
        try {
            mediaR = new MediaPlayer();
            mediaR.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaR.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaR.setOutputFile(getRecordingFilePath());
            mediaR.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaR.prepare();
            mediaR.start();
            Toast.makeText(getApplicationContext(), "Recording Started", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopRecording(View view) {
        if (mediaR != null) {
            mediaR.stop();
            mediaR.release();
            mediaR = null;
            Toast.makeText(getApplicationContext(), "Recording Stopped", Toast.LENGTH_SHORT).show();
        }
    }

    public void playAudio(View view) {
        try {
            mediaP = new MediaPlayer();
            mediaP.setDataSource(getRecordingFilePath());
            mediaP.prepare();
            mediaP.start();
            Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRecordingFilePath() {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(directory, RECORDING_FILE_NAME); // Use the constant variable here
        return file.getPath();
    }
}
