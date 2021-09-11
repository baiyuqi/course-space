package com.hbpvu.jec.bookstore.category.repository.dao;


import org.hibernate.annotations.GenericGenerator;

import com.hbpvu.jec.bookstore.common.DateAudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-04
 */

@Entity
@Table(name = "PRODUCT")

public class Product extends DateAudit {
	transient String productCategoryId;
    public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PRODUCT_ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String name;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;
    private double price;

    @Column(name = "PRODUCT_IMAGE_ID")
    private String imageId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    private ProductCategory category;

    @Column(name = "AVAILABLE_ITEM_COUNT")
    private int availableItemCount;


	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getImageId() {
		return imageId;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public int getAvailableItemCount() {
		return availableItemCount;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public void setAvailableItemCount(int availableItemCount) {
		this.availableItemCount = availableItemCount;
	}


}
