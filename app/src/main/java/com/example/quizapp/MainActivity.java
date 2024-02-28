package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitAnswerButton;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        submitAnswerButton = findViewById(R.id.submitAnswerButton);

        questions = new ArrayList<>();
        initializeQuestions();
        displayQuestion(currentQuestionIndex);

        submitAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionIndex = optionsRadioGroup.indexOfChild(findViewById(optionsRadioGroup.getCheckedRadioButtonId()));
                if (selectedOptionIndex == questions.get(currentQuestionIndex).correctAnswerIndex) {
                    score++;
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    displayQuestion(currentQuestionIndex);
                } else {
                    Toast.makeText(MainActivity.this, "Quiz Finished! Your score: " + score, Toast.LENGTH_LONG).show();
                    // Optionally reset the quiz or close the app
                }
            }
        });
    }

    private void initializeQuestions() {
        questions.add(new Question("What is the capital of France?", Arrays.asList("Paris", "London", "Berlin"), 0));
        questions.add(new Question("Who painted the Mona Lisa?", Arrays.asList("Vincent Van Gogh", "Leonardo da Vinci", "Pablo Picasso"), 1));
        questions.add(new Question("What is the largest ocean?", Arrays.asList("Atlantic Ocean", "Indian Ocean", "Pacific Ocean"), 2));
        questions.add(new Question("What is the chemical symbol for Gold?", Arrays.asList("Au", "Ag", "Pb"), 0));
        questions.add(new Question("How many continents are there?", Arrays.asList("Five", "Six", "Seven"), 2));
        questions.add(new Question("What is the capital of Japan?", Arrays.asList("Seoul", "Beijing", "Tokyo"), 2));
        questions.add(new Question("What is the hardest natural substance on Earth?", Arrays.asList("Gold", "Diamond", "Iron"), 1));
        questions.add(new Question("What is the longest river in the world?", Arrays.asList("Nile", "Amazon", "Yangtze"), 1));
        questions.add(new Question("Who wrote 'Hamlet'?", Arrays.asList("William Shakespeare", "Charles Dickens", "Leo Tolstoy"), 0));
        questions.add(new Question("What is the capital of Australia?", Arrays.asList("Sydney", "Canberra", "Melbourne"), 1));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Mars", "Jupiter", "Saturn"), 0));
    }


    private void displayQuestion(int index) {
        Question currentQuestion = questions.get(index);
        questionTextView.setText(currentQuestion.questionText);
        optionsRadioGroup.clearCheck();
        ((RadioButton) optionsRadioGroup.getChildAt(0)).setText(currentQuestion.options.get(0));
        ((RadioButton) optionsRadioGroup.getChildAt(1)).setText(currentQuestion.options.get(1));
        ((RadioButton) optionsRadioGroup.getChildAt(2)).setText(currentQuestion.options.get(2));
    }
}
