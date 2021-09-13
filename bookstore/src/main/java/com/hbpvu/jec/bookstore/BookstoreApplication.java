package com.hbpvu.jec.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.hbpvu.jec.bookstore.config.GlobalResourceServerConfig;

import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author: Devaraj Reddy, Date : 2019-05-16
 */
@EnableOpenApi
@SpringBootApplication
@ComponentScan(basePackages = {"com.hbpvu.jec.bookstore"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = GlobalResourceServerConfig.class)})

public class BookstoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }

}
