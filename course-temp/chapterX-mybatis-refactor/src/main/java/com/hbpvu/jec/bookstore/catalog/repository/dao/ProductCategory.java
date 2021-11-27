package com.hbpvu.jec.bookstore.catalog.repository.dao;


import org.hibernate.annotations.GenericGenerator;

import com.hbpvu.jec.bookstore.common.DateAudit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


public class ProductCategory extends DateAudit {


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String id;

    private String name;

	private String description;

}
