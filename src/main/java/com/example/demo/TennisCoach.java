package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("thatSillyCoach") //TODO: if not bean ID then default is tennisCoach!
@Component
//@Scope("prototype") //TODO: Scope of the Component is singleton as default, but if you use prototype it will create different objects each time.
public class TennisCoach implements Coach {
    @Autowired // TODO: If you use @Autowired here, then no need fot setter method!
    // TODO: Annotations are like Macros in C++ and scanned before the program runs!
    @Qualifier("randomFortuneService") // TODO: This is to select specific Component or else Spring will get confused about wich Compnents it should AutoWire
    private FortuneService fortuneService;

    //TODO: This was for constructor dependency injection
    //@Autowired //TODO: this is optional from Spring Framework 4.3
    //public TennisCoach(FortuneService fortuneService) {
    //    this.fortuneService = fortuneService;
    //}

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("doing sth.s for startup");
    }

    //For "prototype" scoped beans, Spring does not call the @PreDestroy method.
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("doing sth.s for finish");
    }

    public TennisCoach() {
        System.out.println("Inside default constructor!");
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis 15 mins!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

   // @Autowired //TODO: This is not optional for setter methods!!!
   // public void setFortuneService(FortuneService fortuneService) {
   //     this.fortuneService = fortuneService;
   // }

    //TODO: you cannot put @Autowired here if you used Autowired before setter method. If you put, then it will give nested dependency injection error!
    //TODO: But if you do not use setter method, then if you use @Autowired here you will not get exception! But no need to use
    public String doSomeCrazyStuff(){
        return this.fortuneService.getFortune();
    }
}
