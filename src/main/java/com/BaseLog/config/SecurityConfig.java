package com.BaseLog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(
                                new AntPathRequestMatcher("/funcionario/cadastrar"),
                                new AntPathRequestMatcher("/base/cadastrar"))
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/funcionario/cadastrar", "/base/cadastrar").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }

}
