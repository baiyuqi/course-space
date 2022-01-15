package com.hbpvu.jec.chapter0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("blog")
@RestController
public class BlogManagement {
	@GetMapping()
	public String hello() {
		return "hello world";
	}
	@GetMapping("myblogs")
	public List<Blog> myblogs() {
		List<Blog> rst = new ArrayList<Blog>();
		Blog b1 = new Blog();
		b1.setContent("8888");
		rst.add(b1);
		return rst;
	}

}

class Blog{
	String owner;
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	String title;
	String content;
}