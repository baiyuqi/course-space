package com.hbpvu.jec.chapter0.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hbpvu.jec.chapter0.model.Blog;
import com.hbpvu.jec.chapter0.service.BlogService;


@RequestMapping("blog")
@RestController
public class BlogController {
	@Autowired ApplicationContext ctx;
	@Autowired BlogService bservice;
	
	@GetMapping("myblogs")
	public List<Blog> myblogs() {
		List<Blog> rst = this.bservice.myblogs();
		return rst;
	}


}
