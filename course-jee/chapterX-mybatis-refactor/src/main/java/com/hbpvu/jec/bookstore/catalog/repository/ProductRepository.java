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
import com.hbpvu.jec.bookstore.catalog.repository.mapper.ProductMapper;


@Component
public class ProductRepository {
	@Autowired ProductMapper mapper;

	public List<Product> findAll() {
		return mapper.findAll();
	}

	public Page<Product> findAll(Pageable pageable) {
		return null;
	}
	public Optional<Product> findById(String id) {
		Product rst = mapper.findById(id);
		 Optional<Product> op = Optional.ofNullable(rst);
		 return op;
	}

	public Product save(Product product) {
		String id = UUID.randomUUID().toString();
		product.setId(id);
		mapper.save(product);
		return product;
	}

	public int deleteById(String id) {
		return mapper.deleteById(id);
	}
}
