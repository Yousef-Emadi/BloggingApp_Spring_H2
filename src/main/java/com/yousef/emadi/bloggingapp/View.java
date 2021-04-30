package com.yousef.emadi.bloggingapp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */


public class View {

    //variables
    Scanner input = new Scanner(System.in);

    //methods
    public int userMenu() {
        System.out.println("\nPlease, enter an option number");
        System.out.print("\n   1. Add a new post");
        System.out.print("\n   2. List all of the blog posts");
        System.out.print("\n   3. Find a post by title");
        System.out.print("\n   4. Find a post by a keyword");
        System.out.print("\n   5. Update a post");
        System.out.print("\n   6. Delete a post");
        System.out.print("\n   0. Exit from application\n");

        int commandNumber = getNumberFromUser(0,6);

        return commandNumber;
    }


    public String getTitle(){
        System.out.print("Please enter the title: ");
        String title = input.nextLine();
        return title;
    }

    public String getBody(){
        System.out.print("Please enter the post body: ");
        String body = input.nextLine();
        return body;
    }


    public char askToContinue(){
        System.out.print("\nWould you like to write another post? (y/n)");
        char c = input.next().charAt(0);
        return c;
    }

    public String getKeyword() {
        System.out.print("\nPlease enter a keyword to find the post: ");
        String keyword = input.nextLine();
        return keyword;
    }




    public void showPost(Post post) {
        System.out.println(
                "\n<< " + post.title + " >>\n" +
                        post.body+
                        "\n------------------------------------------------------------------"
        );
    }

    //Messages

    public void messageDone(){System.out.println("\n<<<<<   We are done!   >>>>>");}
    public void messageEmptyValue(){System.out.println("\n<<<<<   Sorry! Empty value is not acceptable   >>>>>");}

    public void messageRedundantTitle(){System.out.println("\n<<<<<   Sorry! This title already exists on the blog. Please try again and select a new title.   >>>>>");}
    public void messagePostNotFound(){  System.out.println("\n <<<<<   Post not found   >>>>>");}
    public void messageUpdatePost(Post oldPost){  System.out.println("\n <<<<<   Post with title:" + oldPost.title + " updated and stored in the blog. >>>>>");}
    public void messageExit() {System.out.println("\n<<<<<   Thank you and have a nice Blog! :)  >>>>> \n" );}


    // Method to get number from user and handles InputMismatchException and logical expressions
    public int getNumberFromUser(int min, int max){
        Scanner scanner = new Scanner(System.in);
        while(true)
            try {
                int userChoice = scanner.nextInt();
                if (!(userChoice >= min && userChoice <= max)) {
                    System.out.print(">>>>>    Please enter an valid option number including ");
                    System.out.print(min);
                    for (int i = min+1; i < max; i++){
                        System.out.print(", " + i);
                    }
                    System.out.print(" and " + max + "\n");

                    continue;
                }
                return userChoice;

            } catch (InputMismatchException ime) {
                System.out.print(">>>>>   Please enter an valid option number including ");
                System.out.print(min);
                for (int i = min+1; i < max; i++){
                    System.out.print(", " + i);
                }
                System.out.print(" and " + max+ "\n");
                scanner.nextLine();
                continue;
            } // end catch
    } // end method getNumberFromUser

    //to consume left-over line after nextInt
    public void leftOverConsumer(){
        System.out.print("\n");
        input.nextLine();
    }


}



