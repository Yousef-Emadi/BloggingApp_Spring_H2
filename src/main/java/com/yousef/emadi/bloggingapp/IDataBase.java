package com.yousef.emadi.bloggingapp;

import org.springframework.data.repository.CrudRepository;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

public interface IDataBase{

    void add(Post post);
    Iterable<Post> list();
    void delete(Post post);
}
