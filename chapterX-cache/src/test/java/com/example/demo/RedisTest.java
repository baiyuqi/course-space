package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.hbpvu.jec.bookstore.BookstoreApplication;

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
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;
    @Test
    public void contextLoads() {
    }
    /**
     * 测试 Redis 操作
     */
    @Test
    public void get() {
        // 测试线程安全，程序结束查看redis中count的值是否为1000
       // ExecutorService executorService = Executors.newFixedThreadPool(1000);
        
		/*
		 * int[] data = IntStream.range(0, 1000).toArray(); for(int i = 0; i <
		 * data.length; i++) {
		 * 
		 * stringRedisTemplate.opsForValue().increment("count", 1);
		 * 
		 * 
		 * }
		 */
        ValueOperations<String, String> op = stringRedisTemplate.opsForValue();
        
        op.set("prudct", "myvalue", 1, TimeUnit.DAYS);
        
        HashOperations<String, Object, Object> oph = stringRedisTemplate.opsForHash();
        Map<String,String> data = new HashMap<String, String>();
        		data.put("k1", "v1");
        		data.put("k2", "v2");
        oph.putAll("map1",data);
		/*
		 * stringRedisTemplate.opsForValue().set("k1", "v1"); String k1 =
		 * stringRedisTemplate.opsForValue().get("k1"); log.debug("【k1】= {}", k1);
		 * 
		 * // 以下演示整合，具体Redis命令可以参考官方文档 String key = "xkcoding:user:1";
		 * redisCacheTemplate.opsForValue().set(key, new User(1L, "user1")); // 对应
		 * String（字符串） User user = (User) redisCacheTemplate.opsForValue().get(key);
		 * log.debug("【user】= {}", user);
		 */
    }
}
