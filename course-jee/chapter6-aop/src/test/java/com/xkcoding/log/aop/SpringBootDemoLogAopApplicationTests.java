package com.xkcoding.log.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hbpvu.jec.log.aop.SpringBootDemoLogAopApplication;
import com.hbpvu.jec.log.aop.controller.TestController;


@SpringBootTest(classes= {SpringBootDemoLogAopApplication.class})
public class SpringBootDemoLogAopApplicationTests {
@Autowired TestController controller;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test1() {
    	controller.test("hhh");
    }

}
