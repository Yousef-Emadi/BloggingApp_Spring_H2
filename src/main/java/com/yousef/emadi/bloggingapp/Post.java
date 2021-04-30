package com.yousef.emadi.bloggingapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

@Entity
public class Post {
    //Fields:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    String body;

    //Constructors:
    public Post() {
    }

    public Post(String title, String body) {
        this.id = 0;
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
