package com.hbpvu.jec.bookstore.catalog.model;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;


/**
 * @author: Devaraj Reddy,
 * Date : 2019-08-27
 */
@Data
public class ProductResource extends EntityModel<Product> {
    
    private Pageable pageable;
    
    public ProductResource(Product content, Link... links) {
        EntityModel.of(content, links);
    }
}
