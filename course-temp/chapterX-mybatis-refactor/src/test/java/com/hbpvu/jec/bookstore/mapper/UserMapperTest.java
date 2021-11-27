package com.hbpvu.jec.bookstore.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hbpvu.jec.bookstore.SpringBootDemoOrmMybatisApplicationTests;
import com.hbpvu.jec.bookstore.catalog.repository.ProductCategoryRepository;
import com.hbpvu.jec.bookstore.catalog.repository.ProductRepository;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * UserMapper 测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 11:25
 */

public class UserMapperTest extends SpringBootDemoOrmMybatisApplicationTests {
    @Autowired
    private ProductRepository productRep;
    @Autowired
    private ProductCategoryRepository categoryRep;
    /**
     * 测试查询所有
     */
    @Test
    public void selectAllUser() {
        List<Product> userList = productRep.findAll();
 //       assertTrue(CollUtil.isNotEmpty(userList));
  
    }

    /**
     * 测试根据主键查询单个
     */
    @Test
    public void selectUserById() {
         List<Product> ps = productRep.findAll();
     
     
    }

    /**
     * 测试保存
     */
    @Test
    public void saveUser() {
       
        Product p = new Product();
       p.setName("human action");
       p.setCreatedAt(new Date());
       p.setUpdatedAt(new Date());
      productRep.save(p);
      
      
     
      ProductCategory c = new ProductCategory();
     c.setName("economics");
     
     c.setCreatedAt(new Date());
     c.setUpdatedAt(new Date());
    categoryRep.save(c);

    }

    /**
     * 测试根据主键删除
     */
  //  @Test
    public void deleteById() {
 //       int i = userMapper.deleteById(1L);
 //       assertEquals(1, i);
    }
}
