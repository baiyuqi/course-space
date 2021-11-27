package com.hbpvu.jec.bookstore.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hbpvu.jec.bookstore.SpringBootDemoOrmMybatisApplicationTests;
import com.hbpvu.jec.bookstore.catalog.repository.ProductRepository;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;

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
    private ProductRepository userMapper;

    /**
     * 测试查询所有
     */
    @Test
    public void selectAllUser() {
        List<Product> userList = userMapper.findAll();
 //       assertTrue(CollUtil.isNotEmpty(userList));
  
    }

    /**
     * 测试根据主键查询单个
     */
    @Test
    public void selectUserById() {
   //     User user = userMapper.findById(1L);
   //     assertNotNull(user);
     
    }

    /**
     * 测试保存
     */
    @Test
    public void saveUser() {
        String salt = UUID.randomUUID().toString();
        Product p = new Product();
       p.setName("testSave3");
       p.setId(salt);
       p.setCreatedAt(new Date());
       p.setUpdatedAt(new Date());
      userMapper.save(p);

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
