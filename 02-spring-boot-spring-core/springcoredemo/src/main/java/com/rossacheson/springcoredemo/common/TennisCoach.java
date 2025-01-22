package com.rossacheson.springcoredemo.common;

import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your back hand volley";
    }
}
