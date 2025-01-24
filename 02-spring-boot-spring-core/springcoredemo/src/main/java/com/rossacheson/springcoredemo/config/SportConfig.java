package com.rossacheson.springcoredemo.config;

import com.rossacheson.springcoredemo.common.Coach;
import com.rossacheson.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquaticCoach") // string here overrides default bean name
    public Coach swimCoach() { // method name is the bean name by default
        return new SwimCoach();
    }

}
