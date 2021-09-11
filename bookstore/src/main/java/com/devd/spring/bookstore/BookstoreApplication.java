package com.devd.spring.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.devd.spring.bookstore.commons.security.GlobalResourceServerConfig;

/**
 * @author: Devaraj Reddy, Date : 2019-05-16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.devd.spring"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = GlobalResourceServerConfig.class)})

public class BookstoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }

}
