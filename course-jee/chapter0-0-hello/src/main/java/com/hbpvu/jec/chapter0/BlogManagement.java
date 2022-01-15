package com.hbpvu.jec.chapter0;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RequestMapping("blog")
@RestController
public class BlogManagement {

	private static final Logger logger = LogManager.getLogger(BlogManagement.class);

	@GetMapping()
	public String hello() {
		log();
		return "hello world";
	}
	private void log() {
		HttpServletRequest sas = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String agent = sas.getHeader("User-Agent");
		logger.info(agent);
		Map<String, String[]> ps = sas.getParameterMap();
	
		try {
			String pjson = new ObjectMapper().writeValueAsString(ps);
			logger.info(pjson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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