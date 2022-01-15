package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hbpvu.jec.bookstore.BookstoreApplication;
import com.hbpvu.jec.bookstore.catalog.controller.ProductCategoryController;
import com.hbpvu.jec.bookstore.catalog.controller.ProductController;

@SpringBootTest(classes= {BookstoreApplication.class})
class DemoApplicationTests {
	@Autowired ProductCategoryController con;
	@Autowired ProductController pcon;
	@Test
	void contextLoads() {
	}
	@Test
	void listCat() {
		pcon.getAllProducts("productName,asc", 0, 20, null);
		pcon.getAllProducts("productName,asc", 0, 20, null);
	}

}
