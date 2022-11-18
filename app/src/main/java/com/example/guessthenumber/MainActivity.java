package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private Button easyLevelBtn, mediumLevelBtn, hardLevelBtn;
    private ImageView exitBtn, infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easyLevelBtn = findViewById(R.id.easyLevelBtn);
        mediumLevelBtn = findViewById(R.id.mediumLevelBtn);
        hardLevelBtn = findViewById(R.id.hardLevelBtn);
        exitBtn = findViewById(R.id.exitBtn);
        infoBtn = findViewById(R.id.infoBtn);

        easyLevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EasyGuessActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
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

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle(getResources().getString(R.string.exitAppTitle))
                        .setMessage(getResources().getString(R.string.exitAppMessage))
                        .setCancelable(false)
                        .setPositiveButton(getResources().getString(R.string.exitAppPositive), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNeutralButton(getResources().getString(R.string.exitAppNegative), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameInfoActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(MainActivity.this)
                .setTitle(getResources().getString(R.string.exitAppTitle))
                .setMessage(getResources().getString(R.string.exitAppMessage))
                .setCancelable(false)
                .setPositiveButton(getResources().getString(R.string.exitAppPositive), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNeutralButton(getResources().getString(R.string.exitAppNegative), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
}