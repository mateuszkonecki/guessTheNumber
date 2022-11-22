package pl.mateuszkonecki.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.guessthenumber.R;
import com.example.guessthenumber.databinding.ActivityHardGuessBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Random;

public class HardGuessActivity extends AppCompatActivity {

    private ActivityHardGuessBinding binding;
    private Random random = new Random();

    public static final String SHARED_PREF = "shared_pref";
    public static final String SHARED_PREF_KEY = "hardScore";

    private int wylosowana;
    private int tryCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHardGuessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playAgain();

        binding.checkNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = binding.numberET.getText().toString();

                if(userInput.isEmpty()) {
                    binding.numberET.setError(getResources().getString(R.string.empty));
                } else if(userInput.contains(".")) {
                    binding.numberET.setError(getResources().getString(R.string.incorrectFormat));
                } else {
                    int userInputInt = Integer.parseInt(userInput);

                    if(wylosowana > userInputInt) {
                        tryCounter++;

                        binding.lessOrGreat.setVisibility(View.VISIBLE);
                        binding.randedNumber.setVisibility(View.VISIBLE);
                        binding.userNumberTV.setVisibility(View.VISIBLE);

                        binding.userNumberTV.setText(userInput);
                        binding.lessOrGreat.setImageResource(R.drawable.ic_arrow_greater_24);
                        binding.randedNumber.setText(R.string.myNumberTV);
                        binding.numberET.setText("");
                    }
                    if(wylosowana < userInputInt) {
                        tryCounter++;

                        binding.lessOrGreat.setVisibility(View.VISIBLE);
                        binding.randedNumber.setVisibility(View.VISIBLE);
                        binding.userNumberTV.setVisibility(View.VISIBLE);

                        binding.userNumberTV.setText(userInput);
                        binding.lessOrGreat.setImageResource(R.drawable.ic__arrow_less_24);
                        binding.randedNumber.setText(R.string.myNumberTV);
                        binding.numberET.setText("");
                    }
                    if(wylosowana == userInputInt) {
                        new MaterialAlertDialogBuilder(HardGuessActivity.this)
                                .setTitle(getResources().getString(R.string.congratsTitle))
                                .setMessage(getResources().getString(R.string.congratsMessage))
                                .setCancelable(false)
                                .setBackground(getDrawable(R.drawable.material_background))
                                .setPositiveButton(getResources().getString(R.string.congratsPositive), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        playAgain();
                                    }
                                })
                                .setNeutralButton(getResources().getString(R.string.congratsNeutral), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        saveData();
                                        finish();
                                        overridePendingTransition(R.anim.left_in, R.anim.right_out);
                                    }
                                })
                                .show();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(HardGuessActivity.this)
                .setTitle(getResources().getString(R.string.exitTitle))
                .setMessage(getResources().getString(R.string.exitMessage))
                .setCancelable(false)
                .setIcon(getDrawable(R.drawable.ic_warning_24))
                .setBackground(getDrawable(R.drawable.material_background))
                .setPositiveButton(getResources().getString(R.string.exitPositive), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        overridePendingTransition(R.anim.left_in, R.anim.right_out);
                    }
                })
                .setNeutralButton(getResources().getString(R.string.exitNegative), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    private void playAgain() {
        tryCounter = 1;
        binding.lessOrGreat.setVisibility(View.INVISIBLE);
        binding.randedNumber.setVisibility(View.INVISIBLE);
        binding.userNumberTV.setVisibility(View.INVISIBLE);
        wylosowana = random.nextInt(100)-100;
        binding.numbersRange.setText("-100 --> 100");
        binding.numberET.setText("");
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SHARED_PREF_KEY, String.valueOf(tryCounter));
        editor.apply();
    }
}