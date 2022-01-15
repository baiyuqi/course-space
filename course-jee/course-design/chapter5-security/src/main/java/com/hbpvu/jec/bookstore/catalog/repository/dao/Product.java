package com.hbpvu.jec.bookstore.catalog.repository.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbpvu.jec.bookstore.catalog.web.ProductResponse;
import com.hbpvu.jec.bookstore.commons.annotation.Dictionary;
import com.hbpvu.jec.bookstore.commons.util.DateAudit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends DateAudit {

    @Id
    private String productId;

    private String productName;

    private String description;
    private double price;

    private String imageId;

    private String productCategoryId;
    @Dictionary(entityType=ProductCategory.class, id="productCategoryId", name="productCategoryName")
    @Transient 
    private String productCategoryName;

    private int availableItemCount;
    
  
    public static ProductResponse fromEntity(Product product) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(product, ProductResponse.class);
    }
}
