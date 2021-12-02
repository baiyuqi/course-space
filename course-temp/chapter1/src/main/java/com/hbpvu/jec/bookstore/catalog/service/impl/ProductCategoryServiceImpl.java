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
    		ProductCategory cat) {

        
        ProductCategory savedProductCategory = productCategoryRepository.save(cat);
        return savedProductCategory.getId();
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
    public void updateProductCategory(ProductCategory cat ) {

        //To check weather the ProductCategory exist.
        ProductCategory old =
                this.getProductCategory(cat.getId());
        old.setName(cat.getName());
        old.setDescription(cat.getName());
     

        productCategoryRepository.save(old);

    }
    
    @Override
    public Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size) {
        Pageable pageable = PageUtil.parsePage(sort, page, size);
		return productCategoryRepository.findAll(pageable);
    }
    
}
