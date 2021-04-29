package com.yousef.emadi.bloggingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

@Controller
public class MainController {

    //new objects
    private View view;

    @Autowired
    private PostRepository postRepository;

    public void Configure(View view, PostRepository postRepository) {
        this.view = view;
        this.postRepository = postRepository;
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
        char response = 'n';
        do {
            Post newPost = view.getNewPost();
            if (!isTitleNew(newPost.title)) {
                view.messageRedundantTitle();
                view.getNewPost();
            };
            if (newPost != null) {
                postRepository.save(newPost);
                response = view.askToContinue();
            }
        }
        while ( response == 'y' );
        view.messageDone();
    }

    private void doList() {
        for (Post post: postRepository.findAll()
             ) {
            view.showPost(post);
        }
    }

    private void doFindByTitle() {
        String title = view.getTitle();
        int counter = 0;
        for (Post post: postRepository.findAll()
        ) {
            if (post.title == title)
            view.showPost(post);
            counter++;
        }
        if (counter == 0) view.messagePostNotFound();
    }

    private void doFindByKeyword() {
        String keyword = view.getKeyword();
        int counter = 0;
        for (Post post: postRepository.findAll()
        ) {
            if (post.body.contains(keyword) || post.title.contains(keyword))
                view.showPost(post);
            counter++;
        }
        if (counter == 0) view.messagePostNotFound();
    }

    private void doUpdate() {
        System.out.println("(to be developed)");
    }

    private void doDelete() {
        String title = view.getTitle();
        int counter = 0;
        for (Post post: postRepository.findAll()
        ) {
            if (post.title == title){
                postRepository.delete(post);
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
        for (Post post: postRepository.findAll()
        ) {
            if (post.title == title)
            return false;
        }
        return true;

    }

}
//
//
//    private void doFindAndShowMember() {
//        int id = myUI.getIdToSearch();
//        Member foundMember = members.findMember(id);
//        if (foundMember != null)
//            myUI.showMemberVerticalStyle(foundMember);
//        else
//            myUI.memberNotFoundMessage();
//    }

//
//    private void doListMembers() {
//        members.listMember().forEach(member -> myUI.showMemberLineStyle(member));
//    }
//
//    private void doUpdateMember() {
//        int id = myUI.getIdToSearch();
//        Member oldMember = members.findMember(id);
//        if (oldMember != null){
//            Member newMember = myUI.getNewMember();
//            members.addMember(newMember);
//            members.removeMember(oldMember);
//            myUI.updateMemberMessage(oldMember, newMember);
//        }
//        else
//            myUI.memberNotFoundMessage();
//    }
//
//
//    private void doRemoveMember() {
//        int id = myUI.getIdToSearch();
//        Member foundMember = members.findMember(id);
//        if (foundMember != null){
//            members.removeMember(foundMember);
//            myUI.memberRemovedMessage(foundMember);
//        }
//        else
//            myUI.memberNotFoundMessage();
//
//    }


