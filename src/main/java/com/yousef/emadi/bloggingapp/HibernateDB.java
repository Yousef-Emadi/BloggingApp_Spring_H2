package com.yousef.emadi.bloggingapp;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

public class HibernateDB implements IDataBase {

    //Fields:
    private PostRepository postRepository = BloggingAppApplication.ctx.getBean(PostRepository.class);

    //Methods
    @Override
    public void add(Post post) {
        if (post != null) postRepository.save(post);
    }

    @Override
    public Iterable<Post> list() {
        return postRepository.findAll();
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}