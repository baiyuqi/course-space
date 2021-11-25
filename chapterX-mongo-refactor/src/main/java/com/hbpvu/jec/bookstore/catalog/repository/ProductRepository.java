package com.hbpvu.jec.bookstore.catalog.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-06
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
