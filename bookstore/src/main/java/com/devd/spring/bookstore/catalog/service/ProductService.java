package com.devd.spring.bookstore.catalog.service;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devd.spring.bookstore.catalog.repository.dao.Product;
import com.devd.spring.bookstore.catalog.web.CreateProductRequest;
import com.devd.spring.bookstore.catalog.web.ProductResponse;
import com.devd.spring.bookstore.catalog.web.UpdateProductRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface ProductService {

  String createProduct(@Valid CreateProductRequest createProductRequest);

  ProductResponse getProduct(String productId);

  void deleteProduct(String productId);

  void updateProduct(UpdateProductRequest updateProductRequest);

  Page<Product> findAllProducts(Pageable pageable);

  Page<ProductResponse> getAllProducts(String sort, Integer page, Integer size);
}
