package com.hbpvu.jec.bookstore.catalog.repository.dao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.hbpvu.jec.bookstore.commons.util.DateAudit;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-04
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory extends DateAudit {

    @Id
    private String productCategoryId;


    private String productCategoryName;


	private String description;
	

}
