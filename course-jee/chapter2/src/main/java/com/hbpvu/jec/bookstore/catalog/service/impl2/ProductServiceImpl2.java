package com.hbpvu.jec.bookstore.catalog.service.impl2;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;
import com.hbpvu.jec.bookstore.catalog.service.ProductService;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-06
 */
@Service
@Primary
public class ProductServiceImpl2 implements ProductService {

    @PersistenceContext  EntityManager em;
    @Autowired
    ObjectMapper objectMapper;
@Transactional
    @Override
    public String createProduct(Product product) {
/*
        Optional<ProductCategory> productCategoryOptional =
                productCategoryRepository.findById(product.getCategory() == null?"":product.getCategory().getId());

        ProductCategory productCategory = productCategoryOptional.orElseThrow(() -> new RuntimeException("ProductCategory doesn't exist!"));
        */
         em.persist(product);
        return product.getId();
    }

    @Override
    public Product getProduct(String productId) {
    	Product rst = em.find(Product.class, productId);
        return rst;
    }

    @Transactional
    @Override
    public void deleteProduct(String productId) {

    	Product rst = em.find(Product.class, productId);
        em.remove(rst);
    }
    @Transactional
    @Override
    public void updateProduct(Product product) {

    	Product productExisting = em.find(Product.class, product.getId());
      
    

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
        	ProductCategory productCategory = em.find(ProductCategory.class, product.getProductCategoryId());
            productExisting.setCategory(productCategory);
        }

        if (product.getAvailableItemCount() != 0) {
            productExisting.setAvailableItemCount(product.getAvailableItemCount());
        }

        productExisting.setCreatedAt(productExisting.getCreatedAt());

        em.persist(productExisting);
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
       List<Product> data = em.createQuery("from Product", Product.class).setFirstResult((int)pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        
        Page<Product> rst = new  PageImpl<Product>(data,pageable, data.size());
        return rst;
    }
}
