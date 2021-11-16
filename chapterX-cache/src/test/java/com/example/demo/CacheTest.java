package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;

import com.hbpvu.jec.bookstore.BookstoreApplication;
import com.hbpvu.jec.bookstore.catalog.controller.ProductCategoryController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * <p>
 * Redis测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-15 17:17
 */
@SpringBootTest(classes= {BookstoreApplication.class})
@Slf4j
public class CacheTest {

    @Autowired
    private ProductCategoryController con;

    @Test
    public void contextLoads() {
    }
    /**
     * 测试 Redis 操作
     */
    @Test
    public void requestCategoryPage() {
    ResponseEntity<?> rst = con.getAllProductCategories("productCategoryName,asc", 0, 10, null);
     rst = con.getAllProductCategories("productCategoryName,asc", 0, 10, null);
    System.out.println(rst);
    }
}
