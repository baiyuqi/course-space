package com.hbpvu.jec.bookstore.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hbpvu.jec.bookstore.account.service.AppUserDetailsService;

/**
 * Created by jack on 2017/4/27.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	 http
    	 .csrf().disable()
         .cors()
         .and()
         .headers()
         .frameOptions()
         .disable()
         .and()
         .requestMatchers()
         .and()
         .authorizeRequests()
         
       //  .antMatchers("/swagger-resources/**","/actuator/**", "/api-docs/**", "/h2-console/**", "/signin", "/authorize", "/signup").permitAll()
       //  .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
       //  .antMatchers(HttpMethod.GET, "/product**/**").permitAll()
        // .antMatchers(HttpMethod.GET, "/review/**").permitAll()
        // .antMatchers(HttpMethod.GET, "/image/**").permitAll()
        // .antMatchers(HttpMethod.GET, "/login.html").permitAll()
        // .antMatchers( "/login").permitAll()
         .antMatchers("/**").permitAll();
    	  http.formLogin();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}