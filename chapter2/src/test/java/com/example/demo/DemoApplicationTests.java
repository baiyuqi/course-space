package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hbpvu.jec.bookstore.BookstoreApplication;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;

@SpringBootTest(classes=BookstoreApplication.class)
class DemoApplicationTests {
	@PersistenceContext  EntityManager em;
	@Test
	void contextLoads() {
	}
	@Transactional
	@Test
	void save() {
		Product p = new Product();
		p.setName("kk");
		em.persist(p);
		em.flush();
	}
	
	@Test
	void test1() {
		TypedQuery<Product> q = em.createQuery("from Product", Product.class );
		List<Product> rst = q.getResultList();
		for(Product p : rst) {
			System.out.println(p.getName());
		}
		
		
	}

}
