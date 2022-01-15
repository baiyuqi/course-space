package com.hbpvu.jec.bookstore.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.catalog.repository.ProductCategoryRepository;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;
import com.hbpvu.jec.bookstore.catalog.service.ProductCategoryService;
import com.hbpvu.jec.bookstore.catalog.web.CreateProductCategoryRequest;
import com.hbpvu.jec.bookstore.catalog.web.UpdateProductCategoryRequest;
import com.hbpvu.jec.bookstore.commons.util.CopyUtil;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-06
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public String createProductCategory(
        @Valid CreateProductCategoryRequest createProductCategoryRequest) {
        ProductCategory productCategory =new ProductCategory();
        CopyUtil.copy(createProductCategoryRequest, productCategory);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return savedProductCategory.getProductCategoryId();
    }

    @Override
    public ProductCategory getProductCategory(String productCategoryId) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(productCategoryId);
        ProductCategory productCategory = productCategoryOptional.orElseThrow(() -> new RuntimeException("Product Category doesn't exist!"));
        return productCategory;
    }

    @Override
    public void deleteProductCategory(String productCategoryId) {

        productCategoryRepository.deleteById(productCategoryId);

    }

    @Override
    public void updateProductCategory(UpdateProductCategoryRequest updateProductCategoryRequest) {

        //To check weather the ProductCategory exist.
        ProductCategory getProductCategory =
                this.getProductCategory(updateProductCategoryRequest.getProductCategoryId());
        CopyUtil.copy(updateProductCategoryRequest, getProductCategory);
        getProductCategory.setCreatedAt(getProductCategory.getCreatedAt());
        productCategoryRepository.save(getProductCategory);

    }
    
    @Override
    public Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size) {
        
        Pageable pageable = PageUtils.getPageable(sort, page, size);
        
        return productCategoryRepository.findAll(pageable);
    }


}
