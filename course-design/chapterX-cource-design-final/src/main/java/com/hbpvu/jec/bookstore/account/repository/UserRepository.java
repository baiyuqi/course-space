package com.hbpvu.jec.bookstore.account.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.account.repository.dao.User;

import javax.transaction.Transactional;

/**
 * @author: Devaraj Reddy, Date : 2019-05-17
 */

public interface UserRepository extends MongoRepository<User, Long> {

  Optional<User> findByUserName(String username);

  Optional<User> findByUserNameOrEmail(String uName, String eMail);

  Optional<User> findByUserId(String userId);

  void deleteByUserId(String userId);

  Boolean existsByUserName(String userName);

  Boolean existsByEmail(String email);

}
