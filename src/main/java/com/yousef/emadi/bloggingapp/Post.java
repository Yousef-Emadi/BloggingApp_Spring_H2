package com.yousef.emadi.bloggingapp;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

public class Post {
    //Fields:
    int id;
    String title;
    String body;

    //Constructors:
    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    //getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}