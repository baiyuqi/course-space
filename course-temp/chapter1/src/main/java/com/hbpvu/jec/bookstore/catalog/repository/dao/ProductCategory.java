package com.hbpvu.jec.bookstore.catalog.repository.dao;

import com.hbpvu.jec.bookstore.common.DateAudit;

import java.util.List;

public class ProductCategory extends DateAudit {

	private String id;

	private String name;
	private String description;

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
