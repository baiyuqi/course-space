package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hbpvu.jec.chapter0.Chapter0Application;
import com.hbpvu.jec.chapter0.model.Blog;
import com.hbpvu.jec.chapter0.service.BlogService;

@SpringBootTest(classes= {Chapter0Application.class})
class DemoApplicationTests {
	@Autowired BlogService blogService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void save() {
		Blog blog = new Blog();
		blog.setTitle("我的文章");
		blogService.add(blog);
	}

}
