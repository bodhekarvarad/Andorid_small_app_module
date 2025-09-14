package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech tts;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.text1);
        tts=new TextToSpeech(this,new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int i) {

                tts.setLanguage(Locale.ENGLISH);
            }
        });
    }

    public void convert(View view) {

        tts.speak(e1.getText().toString(),0,null);
    }
}