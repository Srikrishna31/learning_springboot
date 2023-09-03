package com.learning.springboot.mycoolapp.rest;

import com.learning.springboot.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

//    @Autowired
//    public void setCoach(@Qualifier("baseballCoach") Coach theCoach) {
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
