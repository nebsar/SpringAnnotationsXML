package com.example.demo;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private List<String> fortunes;

    @PostConstruct
    private void readFileAndFillFortunes() {
        File f = new File("fortunes.txt");
        if (f.exists()) {
            fortunes = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(
                    new FileReader(f))) {

                String tempLine;

                while ((tempLine = br.readLine()) != null) {
                    fortunes.add(tempLine);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    private void doneRandomFortune() {
        System.out.println("Random fortunes service is being destroyed! " + RandomFortuneService.class.getName());
    }

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        return this.fortunes.get(this.myRandom.nextInt(fortunes.size()));
    }
}
