package com.example.demomusic.controller;

import com.example.demomusic.entity.QuestionRequestEntity;
import com.example.demomusic.exception.QuestionServiceException;
import com.example.demomusic.models.Question;
import com.example.demomusic.services.QuestionService;
import com.example.demomusic.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class QuestionsController {

    QuestionService questionService;

    UserService userService;


    @Autowired
    public QuestionsController(QuestionService questionService,  UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @PostMapping("/question")
    public ResponseEntity<String> postQuestion(@Valid @RequestBody QuestionRequestEntity questionRequestEntity){
        try {

            if(!userService.validateUserRegistered(questionRequestEntity.getUserEmail())){
                throw new QuestionServiceException("User is not Registered");
            }
            questionService.addQuestion(questionRequestEntity.getTitle(),
                    questionRequestEntity.getContent(), questionRequestEntity.getUserEmail());

        } catch (QuestionServiceException questionServiceException){
            return ResponseEntity.internalServerError().body(questionServiceException.getMessage());
        }

        return ResponseEntity.ok().body("Question added successfully.");
    }

    @GetMapping("/questions")
    public ResponseEntity<Set<Question>> listQuestions(){

        return ResponseEntity.ok().body(questionService.listAllQuestions());

    }


}
