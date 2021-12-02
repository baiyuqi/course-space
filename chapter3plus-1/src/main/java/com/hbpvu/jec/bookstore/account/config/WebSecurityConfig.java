package com.hbpvu.jec.bookstore.account.config;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by jack on 2017/4/27.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired UserDetailsService rbac;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	 http
         .cors()
         .and()
     
         .csrf()
         .disable()
         
         .headers()
         .frameOptions()
         .disable()
         .and()
         .requestMatchers()
         .and()
         .authorizeRequests()
         
         .antMatchers("/swagger-resources/**","/actuator/**", "/api-docs/**", "/h2-console/**", "/signin", "/authorize", "/signup").permitAll()
         .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
        // .antMatchers(HttpMethod.GET, "/product**/**").permitAll()
         .antMatchers(HttpMethod.GET, "/review/**").permitAll()
         .antMatchers(HttpMethod.POST, "/user/add").permitAll()
         .antMatchers(HttpMethod.GET, "/image/**").permitAll()
         .antMatchers("/**").authenticated();
    	  http.formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(rbac).passwordEncoder(new BCryptPasswordEncoder());
        
       /* 
           .inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("byq")
            .password(new BCryptPasswordEncoder().encode("root"))
            .roles("USER");
            */
      
    }

}