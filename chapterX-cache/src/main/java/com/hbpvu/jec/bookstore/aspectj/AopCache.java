package com.hbpvu.jec.bookstore.aspectj;


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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

import javax.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>
 * 使用 aop 切面记录请求日志信息
 * </p>
 *
 * @author yangkai.shen
 * @author chen qi
 * @date Created in 2018-10-01 22:05
 */
@Aspect
@Component
@Slf4j
public class AopCache {
	ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;
    /**
     * 切入点
     */
   @Pointcut("@annotation(com.hbpvu.jec.bookstore.aspectj.MyCache)")
    public void catche() {
    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("catche()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {

        Map<String, Object> ps = getNameAndValue(point);
        String key = key(ps);
        if(cached(key))
        	return getCache(key);
        Object result = point.proceed();
        cache(key, result);
       
        return result;
    }
    boolean cached(String key) {
    	return redisCacheTemplate.hasKey(key);
    }
    private Object getCache(String key) {

    		Object rst = redisCacheTemplate.opsForValue().get(key);
		
			return rst;
    
	}

	void cache(String key, Object data){

			redisCacheTemplate.opsForValue().set(key,(Serializable)data);
		

    }

    /**
     *  获取方法参数名和参数值
     * @param joinPoint
     * @return
     */
    String key(Map<String, Object> data) {
    	Set<String> keys = new TreeSet<String>(data.keySet());
    	String rst = "";
    	for(String k : keys) {
    		rst = rst + k + data.get(k);
    	}
    	return rst;
    	
    }
    private Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {

        final Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        final String[] names = methodSignature.getParameterNames();
        final Object[] args = joinPoint.getArgs();

        if (names.length == 0 || args.length == 0) {
            return Collections.emptyMap();
        }
        if (names.length != args.length) {
            log.warn("{}方法参数名和参数值数量不一致", methodSignature.getName());
            return Collections.emptyMap();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], args[i]);
        }
        return map;
    }

 
}
class CachedData{
	public Class type;
	public String data;
	
	public CachedData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CachedData(Class type, String data) {
		super();
		this.type = type;
		this.data = data;
	}
}