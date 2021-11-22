package com.hbpvu.jec.chapter0.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hbpvu.jec.chapter0.model.Blog;

@Service
public class BlogService {
	public List<Blog> myblogs() {
		List<Blog> rst = new ArrayList<Blog>();
		Blog b1 = new Blog();
		b1.setContent("8888");
		rst.add(b1);
		 b1 = new Blog();
		b1.setContent("9999");
		rst.add(b1);
		return rst;
	}
}
