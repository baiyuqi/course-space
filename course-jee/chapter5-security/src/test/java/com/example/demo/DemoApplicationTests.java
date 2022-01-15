package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbpvu.jec.bookstore.BookstoreApplication;
import com.hbpvu.jec.bookstore.catalog.repository.ProductCategoryRepository;
import com.hbpvu.jec.bookstore.catalog.repository.ProductRepository;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;

@SpringBootTest(classes= {BookstoreApplication.class})
class DemoApplicationTests {
	@Autowired ProductRepository repo;
	@Autowired ProductCategoryRepository crepo;

	@Test
	void contextLoads() {
	}
	@Test
	void dataExtract() throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		FileOutputStream out = new FileOutputStream("d:/datatransfer/products.json");
		List<Product> data = repo.findAll();
		mapper.writeValue(out, data);
		out.close();
		
	}
	@Test
	void dataExtract1() throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		FileOutputStream out = new FileOutputStream("d:/datatransfer/productcats.json");
		List<ProductCategory> data = crepo.findAll();
		mapper.writeValue(out, data);
		out.close();
		
	}

}
