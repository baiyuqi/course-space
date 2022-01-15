package com.hbpvu.jec.bookstore.account.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbpvu.jec.bookstore.account.repository.dao.Role;

@Controller
public class LoginController {

	  @GetMapping("/login")
	  public String login() {
	        return "redirect: login.html";
	    }
}
