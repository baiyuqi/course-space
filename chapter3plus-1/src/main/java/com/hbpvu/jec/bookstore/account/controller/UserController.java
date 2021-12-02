package com.hbpvu.jec.bookstore.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbpvu.jec.bookstore.account.repository.dao.MyUser;
import com.hbpvu.jec.bookstore.account.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired UserService userService;
	@PostMapping("add")
	public String add(@RequestBody MyUser user){
		userService.add(user);
		return "success";
		
	}

}
