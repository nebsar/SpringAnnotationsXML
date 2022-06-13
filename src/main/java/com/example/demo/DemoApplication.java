package com.example.demo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        deneme.Coach tennisCoach1 = context.getBean("denemeCoach", deneme.Coach.class);

        Coach tennisCoach2 = context.getBean("tennisCoach", Coach.class);

        System.out.println(tennisCoach1.getDailyWorkout());

        System.out.println(tennisCoach2.getDailyWorkout());

        System.out.println(tennisCoach2.getDailyFortune());

        System.out.println(tennisCoach2.doSomeCrazyStuff());

        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(swimCoach.getDailyWorkout());

        System.out.println(swimCoach.getDailyFortune());

        System.out.println(swimCoach.doSomeCrazyStuff());

        System.out.println(swimCoach.getEmail());

        System.out.printf(swimCoach.getTeam());


        context.close();

    }

}
