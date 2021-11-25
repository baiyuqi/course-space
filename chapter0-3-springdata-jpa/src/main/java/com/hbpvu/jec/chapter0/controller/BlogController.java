package com.hbpvu.jec.chapter0.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbpvu.jec.chapter0.model.Blog;
import com.hbpvu.jec.chapter0.service.BlogService;

@RequestMapping("blog")
@RestController
public class BlogController {
	@Autowired BlogService bservice;
	@GetMapping("allblogs")
	public List<Blog> allblogs() {
		List<Blog> rst = bservice.allblogs();
		return rst;
	}
	@GetMapping("myblogs")
	public List<Blog> myblogs() {
		String currentUser = "male";//从上下文中取到当前用户
		List<Blog> rst = bservice.myblogs(currentUser);
		return rst;
	}
	@PostMapping("add")
	public String add(@RequestBody Blog blog) {
		bservice.add(blog);
		return "success";
	}
	
	
	

}
