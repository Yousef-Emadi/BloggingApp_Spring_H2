package com.yousef.emadi.bloggingapp;

import java.util.Optional;

public class HibernateDB implements PostRepository{

    private PostRepository postRepository = BloggingAppApplication.ctx.getBean(PostRepository.class);

    @Override
    public <S extends Post> S save(S s) {
        return null;
    }

    @Override
    public <S extends Post> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Post> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Post> findAll() {
        return null;
    }

    @Override
    public Iterable<Post> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void deleteAll(Iterable<? extends Post> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean add(Post post) {
        Post newPost = postRepository.save(post);
            if (newPost != null) {
                postRepository.save(newPost);
                response = view.askToContinue();
            }
        }
        while ( response == 'y' );
        view.messageDone();
        return false;
    }

    @Override
    public Post findByTitle(String title) {
        return null;
    }

    @Override
    public Post findByKeyword(String keyword) {
        return null;
    }

    @Override
    public boolean deletePost(Post post) {
        return false;
    }
}
