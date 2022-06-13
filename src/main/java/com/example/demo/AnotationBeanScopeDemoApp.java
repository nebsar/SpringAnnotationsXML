package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach1 = context.getBean("tennisCoach", Coach.class);

       // Coach theCoach2 = context.getBean("tennisCoach", Coach.class);

       // System.out.println(theCoach1 == theCoach2);

        System.out.println(theCoach1.getDailyFortune());

        context.close();
    }
}
