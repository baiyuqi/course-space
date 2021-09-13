package com.hbpvu.jec.bookstore.catalog.web;

import lombok.Data;
import org.springframework.data.domain.Page;

import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-08-29
 */
@Data
public class ProductCategoriesPagedResponse {
    
    Page<ProductCategory> page;
    Map<String, String> _links = new HashMap<>();
    
}
