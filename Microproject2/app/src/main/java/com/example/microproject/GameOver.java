package com.example.microproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {
    TextView tvPoints;
    ImageView ivNewHighest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        ivNewHighest = findViewById(R.id.ivNewHighest);
        tvPoints = findViewById(R.id.tvPoints);
        int points = getIntent().getIntExtra("Points", 0);
        if (points == 240) {
            ivNewHighest.setVisibility(View.VISIBLE);
        }
        tvPoints.setText(String.valueOf(points));
    }

    public void restart(View view) {
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


        public void exit(View view) {
            Intent intent = new Intent(GameOver.this, MainActivity2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finishAffinity();
        }


}