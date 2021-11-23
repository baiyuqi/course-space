package com.hbpvu.jec.chapter0.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hbpvu.jec.chapter0.model.Blog;

@Service
public class BlogService {
	@PersistenceContext EntityManager em;

	public List<Blog> myblogs() {
		TypedQuery<Blog> query = em.createQuery("from Blog", Blog.class);
		List<Blog> rst = query.getResultList();
		return rst;
	}
	@Transactional
	public void add(Blog blog) {
	
		String id = UUID.randomUUID().toString();
		blog.setId(id);
		em.persist(blog);
	}
}
