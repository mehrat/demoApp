package com.example.demomusic.services.impl;

import com.example.demomusic.models.Question;
import com.example.demomusic.models.User;
import com.example.demomusic.repository.QuestionsDAO;
import com.example.demomusic.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    QuestionsDAO questionsDAO;

    @Autowired
    public QuestionServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    @Override
    public void addQuestion(String title, String content, String userEmail) {

        questionsDAO.addNewQuestion(title, content, userEmail);

    }

    @Override
    public Set<Question> listAllQuestions() {

        return questionsDAO.getAllQuestionFromDataBase();

    }
}
