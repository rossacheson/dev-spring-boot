package com.rossacheson.springcoredemo.rest;

import com.rossacheson.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy(false)
public class DemoController {
    private final Coach myCoach;
    private final Coach anotherCoach;

    // Constructor Injection -- the typical recommended approach
    // Note: @Autowired annotation is optional when there is only one constructor
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach anotherCoach
    ) {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    // Setter Injection -- typically only used for optional dependencies
//    @Autowired
//    public void setCoach(Coach coach) {
//        myCoach = coach;
//    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }

    @GetMapping("/check-coach-scope")
    public String checkCoachScope() {
        return "Comparing beans: myCoach == anotherCoach. Result: " + (this.myCoach == this.anotherCoach);
    }
}
