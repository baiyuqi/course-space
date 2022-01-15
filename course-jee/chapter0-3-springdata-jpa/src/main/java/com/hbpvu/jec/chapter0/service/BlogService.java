package com.hbpvu.jec.chapter0.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hbpvu.jec.chapter0.model.Blog;
import com.hbpvu.jec.chapter0.repository.BlogRepository;

@Service
public class BlogService {
	@Autowired BlogRepository blogRepository;

	public List<Blog> allblogs() {
		
		List<Blog> rst = blogRepository.findAll();
		return rst;
	}
	public List<Blog> myblogs(String me) {
		
		List<Blog> rst = blogRepository.findByOwner(me);
		return rst;
	}
	@Transactional
	public void add(Blog blog) {
	
		String id = UUID.randomUUID().toString();
		blog.setId(id);
		blogRepository.save(blog);
	}
}
