package com.learning.springboot.util;

public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println(" In construtor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
