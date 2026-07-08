package com.application.rps.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) {
        return http.csrf(it -> it.disable())
                .cors(it -> it.disable())
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.GET, "/player/**").permitAll().
                                requestMatchers(HttpMethod.POST, "/player/**").permitAll().
                                requestMatchers(HttpMethod.PATCH, "/player/**").permitAll().
                                requestMatchers(HttpMethod.DELETE, "/player/**").permitAll().
                                requestMatchers(HttpMethod.GET, "/room/**").permitAll().
                                requestMatchers(HttpMethod.POST, "/room/**").permitAll().
                                requestMatchers(HttpMethod.PATCH, "/room/**").permitAll().
                                requestMatchers(HttpMethod.DELETE, "/room/**").permitAll()
                                .requestMatchers("/ws", "/ws/**").permitAll()).build();
    }

    @Bean
    WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/ws").allowedOrigins("*");
            }
        };
    }
}
