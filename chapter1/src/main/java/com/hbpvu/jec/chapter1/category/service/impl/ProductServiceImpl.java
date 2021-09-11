package com.hbpvu.jec.chapter1.category.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbpvu.jec.chapter1.category.repository.ProductCategoryRepository;
import com.hbpvu.jec.chapter1.category.repository.ProductRepository;
import com.hbpvu.jec.chapter1.category.repository.dao.Product;
import com.hbpvu.jec.chapter1.category.repository.dao.ProductCategory;
import com.hbpvu.jec.chapter1.category.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-06
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String createProduct(Product product) {
/*
        Optional<ProductCategory> productCategoryOptional =
                productCategoryRepository.findById(product.getCategory() == null?"":product.getCategory().getId());

        ProductCategory productCategory = productCategoryOptional.orElseThrow(() -> new RuntimeException("ProductCategory doesn't exist!"));
        */
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    @Override
    public Product getProduct(String productId) {
        Optional<Product> productOptional =
                productRepository.findById(productId);

        Product product = productOptional.orElseThrow(() -> new RuntimeException("Product Id doesn't exist!"));
     
        return product;
    }


    @Override
    public void deleteProduct(String productId) {

        productRepository.deleteById(productId);

    }

    @Override
    public void updateProduct(Product product) {

        Optional<Product> productOptional =
                productRepository.findById(product.getId());

        //check weather product exists
        final Product productExisting = productOptional.orElseThrow(() -> new RuntimeException("Product Id doesn't exist!"));

    

        if (product.getName() != null) {
            productExisting.setName(product.getName());
        }

        if (product.getDescription() != null) {
            productExisting.setDescription(product.getDescription());
        }

        if (product.getPrice() != 0) {
            productExisting.setPrice(product.getPrice());
        }

        if (product.getImageId() != null) {
            productExisting.setImageId(product.getImageId());
        }

        if (product.getCategory() != null) {
            Optional<ProductCategory> productCategoryOptional =
                    productCategoryRepository.findById(product.getCategory().getId());

            //check weather product category exists
            ProductCategory productCategory = productCategoryOptional.orElseThrow(() -> new RuntimeException("ProductCategory doesn't exist!"));
            productExisting.setCategory(productCategory);
        }

        if (product.getAvailableItemCount() != 0) {
            productExisting.setAvailableItemCount(product.getAvailableItemCount());
        }

        productExisting.setCreatedAt(productExisting.getCreatedAt());

        productRepository.save(productExisting);
    }

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
    @Override
    public Page<Product> getAllProducts(String sort, Integer page, Integer size) {
        
        //set defaults
        if (size == null || size == 0) {
            size = 20;
        }
        
        //set defaults
        if (page == null || page == 0) {
            page = 0;
        }
        
        Pageable pageable;
        
        if (sort == null) {
            pageable = PageRequest.of(page, size);
        } else {
            Sort.Order order;
            
            try {
                String[] split = sort.split(",");
                
                Sort.Direction sortDirection = Sort.Direction.fromString(split[1]);
                order = new Sort.Order(sortDirection, split[0]).ignoreCase();
                pageable = PageRequest.of(page, size, Sort.by(order));
                
            } catch (Exception e) {
                throw new RuntimeException("Not a valid sort value, It should be 'fieldName,direction', example : 'productName,asc");
            }
            
        }
        Page<Product> allProducts = productRepository.findAll(pageable);
   
        return allProducts;
    }
}
