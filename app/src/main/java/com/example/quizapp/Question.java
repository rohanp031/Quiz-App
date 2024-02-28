package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class Question {
    String questionText;
    List<String> options;
    int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
