package com.example.demomusic.models;

public class Question {

    private String title;
    private String content;
    private String userEmail;

    //TODO: timestamp


    public Question(String title, String content, String userEmail) {
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
