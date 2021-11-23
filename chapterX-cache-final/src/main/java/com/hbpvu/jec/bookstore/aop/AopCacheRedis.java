package com.hbpvu.jec.bookstore.aop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 使用 aop 切面记录请求日志信息
 * </p>
 *
 * @author yangkai.shen
 * @author chen qi
 * @date Created in 2018-10-01 22:05
 */
@Service
@Primary
public class AopCacheRedis implements CacheService{
	   @Autowired
	    private RedisTemplate<String, Serializable> temp;

	    
		public  void cacheIt(String key, Object result) {
			ValueOperations<String, Serializable> ops = temp.opsForValue();
		
			
			ops.set(key, (Serializable)result);
		}

		public Object getCached(String key) {
			ValueOperations<String, Serializable> ops = temp.opsForValue();
			Serializable rst = ops.get(key);
			return rst;
		}

		public boolean cached(String key) {
			boolean rst = temp.hasKey(key);
			return rst;
		}
}
