package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button easyLevelBtn, mediumLevelBtn, hardLevelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easyLevelBtn = findViewById(R.id.easyLevelBtn);
        mediumLevelBtn = findViewById(R.id.mediumLevelBtn);
        hardLevelBtn = findViewById(R.id.hardLevelBtn);

        easyLevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EasyGuessActivity.class);
                startActivity(intent);
            }
        });

        mediumLevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MediumGuessActivity.class);
                startActivity(intent);
            }
        });

        hardLevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HardGuessActivity.class);
                startActivity(intent);
            }
        });
    }
}