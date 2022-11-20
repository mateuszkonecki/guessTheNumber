package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.guessthenumber.databinding.ActivityScoresBinding;

public class ScoresActivity extends AppCompatActivity {

    private ActivityScoresBinding binding;
    private String mediumScore;
    private String hardScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoresBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadMediumData();
        loadHardData();
        binding.lastScoreMedium.setText(mediumScore);
        binding.lastScoreHard.setText(hardScore);

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
    }

    private void loadMediumData() {
        SharedPreferences sharedPreferences = getSharedPreferences(MediumGuessActivity.SHARED_PREF, MODE_PRIVATE);
        mediumScore = sharedPreferences.getString(MediumGuessActivity.SHARED_PREF_KEY, "----");
    }

    private void loadHardData() {
        SharedPreferences sharedPreferences = getSharedPreferences(HardGuessActivity.SHARED_PREF, MODE_PRIVATE);
        hardScore = sharedPreferences.getString(HardGuessActivity.SHARED_PREF_KEY, "----");
    }
}