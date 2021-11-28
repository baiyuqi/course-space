package com.hbpvu.jec.bookstore;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hbpvu.jec.bookstore.catalog.repository.ProductRepository;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;

@SpringBootTest(classes= {BookstoreApplication.class})
class DemoApplicationTests {
	@Autowired ProductRepository rep;
	@Test
	void contextLoads() {
	}
	@Test
	void save() {
		Product p = new Product();
		p.setName("fff");
		p.setCreatedAt(new Date());
		p.setUpdatedAt(new Date());
		rep.save(p);
	}
}
