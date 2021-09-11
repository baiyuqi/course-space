package com.devd.spring.bookstore.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.devd.spring.bookstore.account.repository.dao.OAuthClient;

/**
 * @author: Devaraj Reddy, Date : 2019-05-18
 */
public interface OAuthClientRepository extends CrudRepository<OAuthClient, Long> {

}
