package com.example.android.quizapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * Initializes constants throughout the app
     *
     * @return
     */
    private static final int TEXT_ANSWER_SCORE = 3;
    private static final int SINGLE_CHOICE_ANSWER_SCORE = 1;
    private static final int MULTIPLE_CHOICE_ANSWER_SCORE = 2;
    private static final int FINAL_SCORE_INITIAL = 0;
    private static final int QUESTION_NUMBERS = 2;
    private EditText textInputQuestionOneET;
    private EditText textInputQuestionTwoET;
    private RadioButton correctButtonQ3;
    private RadioButton correctButtonQ5;
    private CheckBox option1Question2;
    private CheckBox option2Question2;
    private CheckBox option3Question2;
    private CheckBox option4Question2;
    private CheckBox option1Question4;
    private CheckBox option2Question4;
    private CheckBox option3Question4;
    private CheckBox option4Question4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputQuestionOneET = findViewById(R.id.nadia);
        textInputQuestionTwoET = findViewById(R.id.name_field);
        correctButtonQ3 = findViewById(R.id.answer3_radio_button);
        correctButtonQ5 = findViewById(R.id.answer5_radio_button);
        option1Question2 = findViewById(R.id.checkbox_option1Q2);
        option2Question2 = findViewById(R.id.checkbox_option2Q2);
        option3Question2 = findViewById(R.id.checkbox_option3Q2);
        option4Question2 = findViewById(R.id.checkbox_option4Q2);
        option1Question4 = findViewById(R.id.checkbox_option1Q4);
        option2Question4 = findViewById(R.id.checkbox_option2Q4);
        option3Question4 = findViewById(R.id.checkbox_option3Q4);
        option4Question4 = findViewById(R.id.checkbox_option4Q4);
    }

    /**
     * Calculates the final score of the user
     *
     * @return
     */
    public void getScore(View view) {
        int finalScore = FINAL_SCORE_INITIAL;
        int maxScore = QUESTION_NUMBERS * (TEXT_ANSWER_SCORE + MULTIPLE_CHOICE_ANSWER_SCORE + SINGLE_CHOICE_ANSWER_SCORE);
        if (isAnswerOneCorrect()) {
            finalScore = finalScore + TEXT_ANSWER_SCORE;
        }
        if (isAnswerTwoCorrect()) {
            finalScore = finalScore + MULTIPLE_CHOICE_ANSWER_SCORE;
        }
        if (isAnswerThreeCorrect()) {
            finalScore = finalScore + SINGLE_CHOICE_ANSWER_SCORE;
        }
        if (isAnswerFourCorrect()) {
            finalScore = finalScore + MULTIPLE_CHOICE_ANSWER_SCORE;
        }

        if (isAnswerFiveCorrect()) {
            finalScore = finalScore + SINGLE_CHOICE_ANSWER_SCORE;
        }
        if (isAnswerSixCorrect()) {
            finalScore = finalScore + TEXT_ANSWER_SCORE;
        }
        if (finalScore == 0) {
            Toast.makeText(this, R.string.message_min_score, Toast.LENGTH_SHORT).show();
        } else {
            if (finalScore == maxScore) {
                Toast.makeText(this, R.string.message_max_score, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.message_your_final_score, finalScore), Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Checks if answer to question 1 is correct or not
     *
     * @return
     */
    private boolean isAnswerOneCorrect() {
        String correctAnswer = getString(R.string.answer1);
        String usersAnswer = textInputQuestionOneET.getText().toString().trim();
        return usersAnswer.equalsIgnoreCase(correctAnswer);
    }

    /**
     * Checks if the correct answers to question2 are checked and the incorrect ones are not checked
     *
     * @return
     */
    private boolean isAnswerTwoCorrect() {
        return option1Question2.isChecked() &&
                !option2Question2.isChecked() &&
                !option3Question2.isChecked() &&
                option4Question2.isChecked();
    }

    /**
     * Checks if the correct answer to question 3 is checked
     *
     * @return
     */
    private boolean isAnswerThreeCorrect() {
        return correctButtonQ3.isChecked();
    }

    /**
     * Checks if the correct answers to question4 are checked and the incorrect ones are not checked
     *
     * @return
     */
    private boolean isAnswerFourCorrect() {
        return option1Question4.isChecked() &&
                option3Question4.isChecked() &&
                option4Question4.isChecked() &&
                !option2Question4.isChecked();
    }

    /**
     * Checks if the correct answer to question 5 is checked
     *
     * @return
     */
    private boolean isAnswerFiveCorrect() {
        return correctButtonQ5.isChecked();
    }

    /**
     * Checks if answer to question 6 is correct or not
     *
     * @return
     */
    private boolean isAnswerSixCorrect() {
        String correctAnswer = getString(R.string.answer6);
        String usersAnswer = textInputQuestionTwoET.getText().toString().trim();
        return usersAnswer.equalsIgnoreCase(correctAnswer);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
    }

    public void onRadioButtonClicked(View view) {
        //Is the view checked?
        boolean checked = ((RadioButton) view).isChecked();
    }
}


