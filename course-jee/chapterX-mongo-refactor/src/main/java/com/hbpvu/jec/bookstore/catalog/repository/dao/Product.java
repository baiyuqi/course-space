package com.hbpvu.jec.bookstore.catalog.repository.dao;


import com.hbpvu.jec.bookstore.common.DateAudit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.annotation.Id;



/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-04
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends DateAudit {

	@Id
    private String id;
	private ProductCategoryDigest category;

	
    private String name;

    private String description;
    private double price;

    private String imageId;


    private int availableItemCount;
    private ProductOrigin origin;

}
