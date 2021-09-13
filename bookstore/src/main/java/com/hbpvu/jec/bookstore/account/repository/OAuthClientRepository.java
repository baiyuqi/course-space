package com.hbpvu.jec.bookstore.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.account.repository.dao.OAuthClient;

/**
 * @author: Devaraj Reddy, Date : 2019-05-18
 */
public interface OAuthClientRepository extends CrudRepository<OAuthClient, Long> {

}
