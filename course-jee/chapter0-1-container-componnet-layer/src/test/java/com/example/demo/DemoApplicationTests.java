package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.hbpvu.jec.chapter0.Chapter0Application;
import com.hbpvu.jec.chapter0.controller.BlogController;
import com.hbpvu.jec.chapter0.model.Blog;

@SpringBootTest(classes= {Chapter0Application.class})
class DemoApplicationTests {
	@Autowired ApplicationContext ctx;
	@Autowired BlogController con;
	@Test
	void contextLoads() {
		System.out.println("kkk");
	}
	@Test
	void callMyBlogs() {
		BlogController c = ctx.getBean(BlogController.class);
		List<Blog> rst = con.myblogs();
	}

}
