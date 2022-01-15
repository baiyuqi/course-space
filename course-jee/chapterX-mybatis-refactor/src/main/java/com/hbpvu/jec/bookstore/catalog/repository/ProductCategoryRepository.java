package com.hbpvu.jec.bookstore.catalog.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;
import com.hbpvu.jec.bookstore.catalog.repository.mapper.ProductCategoryMpper;


@Component
public class ProductCategoryRepository {
	public List<ProductCategory> findAll() {
		return mapper.findAll();
	}
	public Page<ProductCategory> findAll(Pageable pageable) {
		return null;
	}
	public Optional<ProductCategory> findById(String id) {
		ProductCategory rst = mapper.findById(id);
		 Optional<ProductCategory> op = Optional.ofNullable(rst);
		 return op;
	}

	public ProductCategory save(ProductCategory productCategory) {
		String id = UUID.randomUUID().toString();
		productCategory.setId(id);
		mapper.save(productCategory);
		return productCategory;
	}

	public int deleteById(String id) {
		return mapper.deleteById(id);
	}

	@Autowired ProductCategoryMpper mapper;
}
