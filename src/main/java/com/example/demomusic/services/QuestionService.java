package com.example.demomusic.services;

import com.example.demomusic.models.Question;

import java.util.Set;

public interface QuestionService {

    void addQuestion(String title, String Content, String userEmail);

    Set<Question> listAllQuestions();
}
