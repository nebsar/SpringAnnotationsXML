package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{


    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;
    @Override
    public String getDailyWorkout() {
        return "Swim 1 hrs";
    }

    @Override
    public String getDailyFortune() {
        return "Swim swim swim";
    }

    @Override
    public String doSomeCrazyStuff() {
        return this.fortuneService.getFortune();
    }

    public String getEmail(){
        return this.email;
    }

    public String getTeam(){
        return this.team;
    }
}
