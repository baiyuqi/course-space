package com.hbpvu.jec.bookstore.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.account.repository.dao.Role;

/**
 * @author: Devaraj Reddy, Date : 2019-05-17
 */
public interface RoleRepository extends MongoRepository<Role, Long> {

  Optional<Role> findByRoleName(String name);

  Boolean existsByRoleName(String roleName);

  @Override
  List<Role> findAll();
}
