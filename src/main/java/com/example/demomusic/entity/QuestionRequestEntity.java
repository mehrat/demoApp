package com.example.demomusic.entity;

import jakarta.validation.constraints.NotNull;

public class QuestionRequestEntity {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String userEmail;

    public QuestionRequestEntity(String title, String content, String userEmail) {
        this.title = title;
        this.content = content;
        this.userEmail = userEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
