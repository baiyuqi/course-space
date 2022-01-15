package com.hbpvu.jec.bookstore.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpvu.jec.bookstore.account.repository.dao.MyUser;
import com.hbpvu.jec.bookstore.account.repository.dao.UserRoleRelation;

public interface UserRoleRepository extends JpaRepository<UserRoleRelation,String>{
	List<UserRoleRelation> findByUserId(String userId);

}
