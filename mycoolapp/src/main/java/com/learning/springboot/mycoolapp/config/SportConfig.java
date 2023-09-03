package com.learning.springboot.mycoolapp.config;

import com.learning.springboot.util.Coach;
import com.learning.springboot.util.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    Coach swimCoach() {
        return new SwimCoach();
    }
}
