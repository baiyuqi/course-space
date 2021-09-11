package com.devd.spring.bookstore.catalog.service;

import javax.validation.Valid;
import org.springframework.data.domain.Page;

import com.devd.spring.bookstore.catalog.repository.dao.ProductCategory;
import com.devd.spring.bookstore.catalog.web.CreateProductCategoryRequest;
import com.devd.spring.bookstore.catalog.web.UpdateProductCategoryRequest;

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
