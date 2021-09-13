package com.hbpvu.jec.bookstore.payment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import com.hbpvu.jec.bookstore.commons.security.GlobalResourceServerConfig;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
@Configuration
public class PaymentResourceServiceConfig extends GlobalResourceServerConfig {
    
    @Autowired
    private ResourceServerTokenServices tokenServices;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("web").tokenServices(tokenServices);
    }
    
}
