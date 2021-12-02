package com.hbpvu.jec.bookstore.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpvu.jec.bookstore.account.repository.dao.MyUser;

public interface UserRepository extends JpaRepository<MyUser,String>{

}
