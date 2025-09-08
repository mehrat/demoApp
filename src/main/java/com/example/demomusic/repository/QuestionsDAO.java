package com.example.demomusic.repository;

import com.example.demomusic.models.Question;
import org.springframework.stereotype.Repository;
import com.example.demomusic.exception.QuestionServiceException;


import java.util.*;

@Repository
public class QuestionsDAO {

    Set<Question> orderedQuestionsList = new LinkedHashSet<>();
    Map<String, List<Question>> questionData = new LinkedHashMap<>();

    public void addNewQuestion(String title, String content, String userEmail) throws QuestionServiceException {

        try {
            Question question = new Question(title, content, userEmail);
            orderedQuestionsList.add(question);
            List<Question> questions;
            if (questionData.containsKey(userEmail)) {

                questions = questionData.get(userEmail);

            } else {

                questions = new LinkedList<>();

            }
            questions.add(question);
            questionData.put(userEmail, questions);
        } catch (Exception e) {
            throw new QuestionServiceException("Something went wrong while persisting question");
        }

    }

    public Set<Question> getAllQuestionFromDataBase(){

        return orderedQuestionsList;
    }

}
