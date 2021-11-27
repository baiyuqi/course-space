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

import com.hbpvu.jec.chapter0.model.Blog;
import com.hbpvu.jec.chapter0.repository.BlogRepository;

@Service
public class BlogService {
	@Autowired BlogRepository  blogRepository;
	public List<Blog> myblogs() {
		String owner = "byq";//来自于当前登录用户。
		List<Blog> rst = blogRepository.findByOwnerOrderByTitleDesc(owner);
		return rst;
	}
	public List<Blog> allblogs() {
	
		List<Blog> rst = blogRepository.findAll();
		return rst;
	}
	public List<Blog> blogsByTitle(String kw) {
		
		List<Blog> rst = blogRepository.findByTitleLike(kw);
		return rst;
	}
	public List<Blog> hitCountGreaterThan(int hitCount){
		List<Blog> rst = blogRepository.findByHitCountGreaterThan(hitCount);
		return rst;
	}
//	@Transactional
	public void add(Blog blog) {
		//String id = UUID.randomUUID().toString();
		//blog.setId(id);
		blogRepository.save(blog);
		/*
		 * 
		 */
		
	}
}
