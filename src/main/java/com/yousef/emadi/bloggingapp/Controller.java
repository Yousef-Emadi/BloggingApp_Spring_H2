package com.yousef.emadi.bloggingapp;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

public class Controller {

    //new objects
    private View view;
    private IDataBase iDataBase;

    public void Configure(View view, IDataBase iDataBase) {
        this.view = view;
        this.iDataBase = iDataBase;
    }


    public void mainController(){
        int command = view.userMenu();
        switch (command) {
            case 1 -> {doAdd();}
            case 2 -> {doList();}
            case 3 -> {doFindByTitle();}
            case 4 -> {doFindByKeyword();}
            case 5 -> {doUpdate();}
            case 6 -> {doDelete();}
            case 0 -> {doExit();}
        }
    }


    private void doAdd() {
        char response = 'y';
        while ( response == 'y'){
            String title = view.getTitle();
            if (title.isBlank() || title == null) {
                view.messageEmptyValue();
                return;
            }
            if (!isTitleNew(title)) {
                view.messageRedundantTitle();
                return;
            }

            String body = view.getBody();
            if (body.isBlank() || body == null) {
                view.messageEmptyValue();
                return;
            }

            Post newPost = new Post (title, body);
            iDataBase.add(newPost);
            response = view.askToContinue();
            view.leftOverConsumer();
        }
        view.messageDone();
    }

    private void doList() {
        for (Post post: iDataBase.list()
             ) {
            view.showPost(post);
        }
    }

    private void doFindByTitle() {
        String title = view.getTitle();
        int counter = 0;
        for (Post post: iDataBase.list()
        ) {
            if (post.title.compareToIgnoreCase(title) == 0) {
                view.showPost(post);
                counter++;
            }
        }
        if (counter == 0) view.messagePostNotFound();
    }

    private void doFindByKeyword() {
        String keyword = view.getKeyword();
        int counter = 0;
        for (Post post: iDataBase.list()
        ) {
            if (containsIgnoreCase(post.body, keyword) || containsIgnoreCase(post.title, keyword)) {
                view.showPost(post);
                counter++;
            }
        }
        if (counter == 0) view.messagePostNotFound();
    }

    private void doUpdate() {
        String title = view.getTitle();
        int counter = 0;
        for (Post post: iDataBase.list()
        ) {
            if (post.title.compareToIgnoreCase(title) == 0){
                String newTitle = post.title;
                String newBody = view.getBody();
                iDataBase.delete(post);
                Post newPost = new Post (newTitle, newBody);
                iDataBase.add(newPost);
                view.messageDone();
                counter++;
                return;
            }
        }
        if (counter == 0) view.messagePostNotFound();

    }

    private void doDelete() {
        String title = view.getTitle();
        int counter = 0;
        for (Post post: iDataBase.list()
        ) {
            if (post.title.compareToIgnoreCase(title) == 0){
                iDataBase.delete(post);
                view.messageDone();
                counter++;
            }
        }
        if (counter == 0) view.messagePostNotFound();
    }


    public void doExit(){
        view.messageExit();
        System.exit(0);
    }


    public boolean isTitleNew(String title){
        for (Post post: iDataBase.list()
        ) {
            if (post.title.compareToIgnoreCase(title) == 0){
                return false;
            }
        }
        return true;
    }

    public boolean containsIgnoreCase(String text, String keyword) {
        return text.toLowerCase().contains(keyword.toLowerCase());
    }
}
