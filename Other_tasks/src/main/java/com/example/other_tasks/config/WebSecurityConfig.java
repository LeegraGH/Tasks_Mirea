package com.example.other_tasks.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import com.example.other_tasks.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests().requestMatchers("/login","/logout","/registration")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .build();
//        .userDetailsService(userDetailsService())
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
//        detailsManager.createUser(new User("leegra", passwordEncoder().encode("qwerty")));
//        return detailsManager;
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
