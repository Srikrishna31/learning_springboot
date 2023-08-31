package com.learning.springboot.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
}
