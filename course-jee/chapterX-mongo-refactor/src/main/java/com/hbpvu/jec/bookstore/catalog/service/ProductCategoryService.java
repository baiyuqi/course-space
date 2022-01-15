package com.hbpvu.jec.bookstore.catalog.service;

import org.springframework.data.domain.Page;

import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface ProductCategoryService {

  String createProductCategory(ProductCategory cat);

  ProductCategory getProductCategory(String productCategoryId);

  void deleteProductCategory(String productCategoryId);

  void updateProductCategory(ProductCategory cat);

  Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size);
}
