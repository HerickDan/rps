package com.application.rps.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filter(HttpSecurity http, CorsConfigurationSource corsConfiguration) {
        return http.csrf(it -> it.disable())
                .cors(it -> it.configurationSource(corsConfiguration))
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.GET, "/player/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/player/**").permitAll()
                                .requestMatchers(HttpMethod.PATCH, "/player/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/player/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/room/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/room/**").permitAll()
                                .requestMatchers(HttpMethod.PATCH, "/room/**").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/room/**").permitAll()
                                .requestMatchers("/ws", "/ws/**").permitAll())
                .build();
    }
}
