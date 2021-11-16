package com.hbpvu.jec.bookstore.catalog.service;

import javax.validation.Valid;
import org.springframework.data.domain.Page;

import com.hbpvu.jec.bookstore.aspectj.MyCache;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;
import com.hbpvu.jec.bookstore.catalog.web.CreateProductCategoryRequest;
import com.hbpvu.jec.bookstore.catalog.web.UpdateProductCategoryRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface ProductCategoryService {

  String createProductCategory(@Valid CreateProductCategoryRequest createProductCategoryRequest);

  ProductCategory getProductCategory(String productCategoryId);

  void deleteProductCategory(String productCategoryId);

  void updateProductCategory(UpdateProductCategoryRequest updateProductCategoryRequest);

  Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size);
}
