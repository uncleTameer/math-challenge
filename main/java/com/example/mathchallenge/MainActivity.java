package com.example.mathchallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNum1, textViewNum2, textViewScore;
    private EditText editTextAnswer;
    private Button btnMultiplicationTable, btnMultiplyUpTo20, btnChallenge, btnCheck;
    private int num1, num2, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        textViewScore = findViewById(R.id.TextViewScore);
        textViewNum1 = findViewById(R.id.num1);
        textViewNum2 = findViewById(R.id.num2);
        editTextAnswer = findViewById(R.id.editTextText3);
        btnMultiplicationTable = findViewById(R.id.button);
        btnMultiplyUpTo20 = findViewById(R.id.button2);
        btnChallenge = findViewById(R.id.button3);
        btnCheck = findViewById(R.id.button4);

        btnMultiplicationTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumbers(1, 9); // Single-digit numbers
            }
        });

        btnMultiplyUpTo20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumbers(0, 20); // Numbers between 0 and 20
            }
        });

        btnChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumbers(0, 100); // Numbers between 0 and 100
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void generateRandomNumbers(int min, int max) {
        Random random = new Random();
        num1 = random.nextInt((max - min) + 1) + min;
        num2 = random.nextInt((max - min) + 1) + min;

        textViewNum1.setText(String.valueOf(num1));
        textViewNum2.setText(String.valueOf(num2));
    }

    private void checkAnswer() {
        String userAnswerStr = editTextAnswer.getText().toString();
        if (!userAnswerStr.isEmpty()) {
            int userAnswer = Integer.parseInt(userAnswerStr);
            int correctAnswer = num1 * num2;

            if (userAnswer == correctAnswer) {
                score++;
                Toast.makeText(this, "Correct! Score: " + score, Toast.LENGTH_SHORT).show();
                // Update the score TextView
                textViewScore.setText("Score: " + score);
            } else {
                Toast.makeText(this, "Incorrect. The correct answer is " + correctAnswer, Toast.LENGTH_SHORT).show();
            }

            editTextAnswer.setText("");
        } else {
            Toast.makeText(this, "Please enter your answer.", Toast.LENGTH_SHORT).show();
        }
    }
}
