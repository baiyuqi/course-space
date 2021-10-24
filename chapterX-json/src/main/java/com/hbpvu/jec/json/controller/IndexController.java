package com.hbpvu.jec.json.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 首页Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-20 21:22
 */
@RestController
public class IndexController {
    @GetMapping("/book")
    public Product index() {
    	Product rst = new Product();
    	rst.setName("相对论");
    	rst.setProduced(new Date());
        return rst;
    }
}
@Getter
@Setter
class Product{
	String name;
	String category;
	String description;
	Date produced;
	int price;
}