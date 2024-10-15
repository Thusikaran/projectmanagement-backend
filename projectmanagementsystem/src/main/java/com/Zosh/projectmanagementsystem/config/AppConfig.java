package com.Zosh.projectmanagementsystem.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class AppConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.sessionManagement(Management ->Management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
                .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
                .csrf(csrf->csrf.disable())
                .cors(cors->cors.configurationSource(corsConfigrationSource())); // connect react that time cors error

        return http.build();
    }

    private CorsConfigurationSource corsConfigrationSource() {
       return new CorsConfigurationSource() {
           @Override
           public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
               CorsConfiguration cfg =new CorsConfiguration();
               cfg.setAllowedOrigins(Arrays.asList(
                       "http://localhost:3000", //react developer
                       "http://localhost:5173",  //react vite developer
                       "http://localhost:4200/"  //angular developer
               ));
               cfg.setAllowedMethods(Collections.singletonList("*")); // define Allow  curd method
               cfg.setAllowCredentials(true);
               cfg.setAllowedHeaders(Collections.singletonList("*"));
               cfg.setExposedHeaders(Arrays.asList("Authorization"));
               cfg.setMaxAge(3600L);
               return cfg;
           }
       };

    }
    // hash our password
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
