package com.hbpvu.jec.chapter0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpvu.jec.chapter0.model.Blog;

public interface BlogRepository extends JpaRepository<Blog,String>{
	
	List<Blog> findByOwnerOrderByTitleDesc(String owner);
	List<Blog> findByTitleLike(String title);
	List<Blog> findByHitCountGreaterThan(int hitCount);
//增删改查
//查当中的定制化部分
}
