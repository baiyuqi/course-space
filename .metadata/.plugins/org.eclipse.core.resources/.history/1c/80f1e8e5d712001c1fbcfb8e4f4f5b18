package com.hbpvu.jec.chapter1.category.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hbpvu.jec.chapter1.category.repository.dao.Product;


/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface ProductService {

  String createProduct(Product product);

  Product getProduct(String productId);

  void deleteProduct(String productId);

  void updateProduct(Product product);

  Page<Product> findAllProducts(Pageable pageable);

  Page<Product> getAllProducts(String sort, Integer page, Integer size);
}
