package com.hbpvu.jec.bookstore.account.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
         
 //        .antMatchers("/swagger-resources/**","/actuator/**", "/api-docs/**", "/h2-console/**", "/signin", "/authorize", "/signup").permitAll()
   //      .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
     //    .antMatchers(HttpMethod.GET, "/product**/**").permitAll()
       //  .antMatchers(HttpMethod.GET, "/review/**").permitAll()
         //.antMatchers(HttpMethod.GET, "/image/**").permitAll()
         .antMatchers("/**").permitAll();
    	  //http.formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("root")
            .password(new BCryptPasswordEncoder().encode("root"))
            .roles("USER");
      
    }

}