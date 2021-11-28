package com.hbpvu.jec.bookstore.catalog.repository.dao;


import com.hbpvu.jec.bookstore.common.DateAudit;



public class Product extends DateAudit {
	String productCategoryId;
    private String id;

	private String name;

    private String description;

    private double price;

    private String imageId;
    private int availableItemCount;

    public int getAvailableItemCount() {
		return availableItemCount;
	}
    public String getDescription() {
		return description;
	}


	public String getId() {
		return id;
	}

	public String getImageId() {
		return imageId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}


	public void setAvailableItemCount(int availableItemCount) {
		this.availableItemCount = availableItemCount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}


}
