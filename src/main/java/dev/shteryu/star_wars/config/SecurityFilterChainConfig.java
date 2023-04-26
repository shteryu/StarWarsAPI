package dev.shteryu.star_wars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import dev.shteryu.star_wars.web.JwtFilter;

@EnableWebSecurity
@Configuration
public class SecurityFilterChainConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests( auth -> {
                    auth
                    .requestMatchers(HttpMethod.POST, "/token").permitAll()
                    .requestMatchers(HttpMethod.GET, "/swagger-ui/*").permitAll()
                    .requestMatchers(HttpMethod.GET, "/people", "/planets", "/films", "/vehicles", "/species").permitAll()
                    .requestMatchers(HttpMethod.POST, "/people", "/planets", "/films", "/vehicles", "/species").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PATCH, "/people", "/planets", "/films", "/vehicles", "/species").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/people", "/planets", "/films", "/vehicles", "/species").hasRole("ADMIN")
                    .anyRequest().authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement((session) -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
    
}
