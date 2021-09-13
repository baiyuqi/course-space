package com.hbpvu.jec.bookstore.billing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import com.hbpvu.jec.bookstore.commons.security.GlobalResourceServerConfig;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-09-20
 */
@Configuration
public class BillingResourceServiceConfig extends GlobalResourceServerConfig {
    
    @Autowired
    private ResourceServerTokenServices tokenServices;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("web").tokenServices(tokenServices);
    }
    
}
