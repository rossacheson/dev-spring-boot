package com.rossacheson.springcoredemo.config;

import com.rossacheson.springcoredemo.common.Coach;
import com.rossacheson.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquaticCoach") // overrides default bean name is the method name
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
