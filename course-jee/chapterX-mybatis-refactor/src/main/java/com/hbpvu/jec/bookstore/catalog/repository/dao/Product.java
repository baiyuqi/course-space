package com.hbpvu.jec.bookstore.catalog.repository.dao;


import org.hibernate.annotations.GenericGenerator;

import com.hbpvu.jec.bookstore.common.DateAudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Product extends DateAudit {
	transient String productCategoryId;
    public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

    private String id;

    private String name;

    private String description;
    private double price;

    private String imageId;

    private ProductCategory category;

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
