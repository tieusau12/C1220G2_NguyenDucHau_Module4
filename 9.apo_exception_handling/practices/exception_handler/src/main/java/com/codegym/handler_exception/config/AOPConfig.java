package com.codegym.handler_exception.config;

import com.codegym.handler_exception.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
