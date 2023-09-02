package com.learning.springboot.mycoolapp.rest;

import com.learning.springboot.mycoolapp.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
