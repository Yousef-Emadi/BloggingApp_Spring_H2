package com.yousef.emadi.bloggingapp;

import org.springframework.data.repository.CrudRepository;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

public interface PostRepository extends CrudRepository<Post, Integer> {

    boolean add(Post post);
    Post findByTitle(String title);
    Post findByKeyword(String keyword);
    boolean deletePost(Post post);
}
