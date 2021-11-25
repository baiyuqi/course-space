package com.hbpvu.jec.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategoryDigest;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductOrigin;
import com.hbpvu.jec.bookstore.catalog.service.ProductService;
@SpringBootTest(classes= {BookstoreApplication.class})
class DemoApplicationTests {
	@Autowired ProductService productService;

	@Test
	void contextLoads() {
	}
	@Test
	void findByCat() {
		Page<Product> rst = productService.findByCategoryId("name,asc", 0, 20, "12345");
		for(Product p : rst.getContent())
			System.out.println(p.getName());
	}
	//@Test
	void addProduct() {
		Product p = new Product();
		p.setName("human action");
		ProductCategoryDigest digest = new ProductCategoryDigest();
		digest.setId("12345");
		digest.setName("art");
		p.setCategory(digest);
		ProductOrigin origin = new ProductOrigin();
		origin.setCountry("china");
		origin.setProvince("chengde");
		origin.setEmail("byq@qq.com");
		p.setOrigin(origin);
		productService.createProduct(p);
	}
}
