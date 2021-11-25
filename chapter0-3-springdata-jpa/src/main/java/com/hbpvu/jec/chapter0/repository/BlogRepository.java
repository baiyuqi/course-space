package com.hbpvu.jec.chapter0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpvu.jec.chapter0.model.Blog;

public interface BlogRepository extends JpaRepository<Blog,String>{
	List<Blog> findByOwner(String owner);
	List<Blog> findByTitleLike(String title);
	//点击数大于1000
}
