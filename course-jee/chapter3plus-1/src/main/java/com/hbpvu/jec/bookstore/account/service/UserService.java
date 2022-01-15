package com.hbpvu.jec.bookstore.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.account.repository.UserRepository;
import com.hbpvu.jec.bookstore.account.repository.dao.MyUser;

@Service
public class UserService {
	@Autowired UserRepository rep;

	public void add(MyUser user) {
		String pwd = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(pwd);
		rep.save(user);
		
	}

}
