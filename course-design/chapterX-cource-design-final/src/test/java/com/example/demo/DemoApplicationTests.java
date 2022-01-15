package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

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
	@Autowired ProductRepository productRepository;
	@Autowired ProductCategoryRepository carRepository;
	@Test
	void contextLoads() {
	}
	@Test
	void loadCatelog() throws Throwable {
	/*	InputStream in = new FileInputStream("d:/datatransfer/products.json");
		ObjectMapper mapper = new ObjectMapper();
		Product[] ps = mapper.readValue(in, Product[].class);
		in.close();
		
		productRepository.saveAll(Arrays.asList(ps));
		*/
		
		InputStream in = new FileInputStream("d:/datatransfer/productcats.json");
		ObjectMapper mapper = new ObjectMapper();
		ProductCategory[] ps = mapper.readValue(in, ProductCategory[].class);
		in.close();
		
		carRepository.saveAll(Arrays.asList(ps));
		
	}
}
