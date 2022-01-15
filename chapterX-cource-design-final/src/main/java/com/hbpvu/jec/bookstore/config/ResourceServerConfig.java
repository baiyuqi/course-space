package com.hbpvu.jec.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Autowired
  private ResourceServerTokenServices tokenServices;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId("web").tokenServices(tokenServices);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .cors()
        .and()
        .headers()
        .frameOptions()
        .disable()
        .and()
        .requestMatchers()
        .and()
        .authorizeRequests()
        .antMatchers("/actuator/**", "/api-docs/**", "/h2-console/**", "/signin", "/authorize", "/signup").permitAll()
        .antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
        .antMatchers(HttpMethod.GET, "/product**/**").permitAll()
        .antMatchers(HttpMethod.GET, "/review/**").permitAll()
        .antMatchers(HttpMethod.GET, "/image/**").permitAll()
        .antMatchers(HttpMethod.GET, "/login").permitAll()
        .antMatchers("/**").authenticated();
  }
}
