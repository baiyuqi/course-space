package com.hbpvu.jec.chapter1.category.repository.dao;


import org.hibernate.annotations.GenericGenerator;

import com.hbpvu.jec.chapter1.common.DateAudit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-04
 */

@Entity
@Table(name = "PRODUCT_CATEGORY")

public class ProductCategory extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PRODUCT_CATEGORY_ID", updatable = false, nullable = false)
    private String id;
	@Column(name = "PRODUCT_CATEGORY_NAME", nullable = false)
    private String name;
	@OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL
    )
    private List<Product> products;
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
	public List<Product> getProducts() {
		return products;
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
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
