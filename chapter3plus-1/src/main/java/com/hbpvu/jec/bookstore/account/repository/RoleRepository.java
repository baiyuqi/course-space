package com.hbpvu.jec.bookstore.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpvu.jec.bookstore.account.repository.dao.MyUser;
import com.hbpvu.jec.bookstore.account.repository.dao.Role;

public interface RoleRepository extends JpaRepository<Role,String>{

}
