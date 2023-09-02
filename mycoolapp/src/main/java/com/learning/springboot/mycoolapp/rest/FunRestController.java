package com.learning.springboot.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;
    @GetMapping("/")
    String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    String getDailyFortune() {
        return "Today is your lucky day";
    }

    @GetMapping("/teaminfo")
    String getTeamInfo() {
        return "Coach: " + coachName + ", Team name: " + teamName;
    }
}
