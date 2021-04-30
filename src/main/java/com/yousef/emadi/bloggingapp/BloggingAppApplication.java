package com.yousef.emadi.bloggingapp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: Blogging App
 * For: Java III, Quiz 2, Practical
 * Teacher: Dr. Talib Hussain
 * Developed by: Yousef Emadi
 * Date: 29-APR-2021
 */

@SpringBootApplication
@RestController
public class BloggingAppApplication implements ApplicationContextAware {
    public static ApplicationContext ctx;

    @Override
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(BloggingAppApplication.class, args);

        View view = new View();
        IDataBase hibernateDB = new HibernateDB();
        Controller controller = new Controller();
        controller.Configure(view, hibernateDB);

        while (true){
            controller.mainController();
        }
    }
}

