package com.hbpvu.jec.bookstore.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.account.repository.UserRepository;
import com.hbpvu.jec.bookstore.account.repository.UserRoleRepository;
import com.hbpvu.jec.bookstore.account.repository.dao.MyUser;
import com.hbpvu.jec.bookstore.account.repository.dao.Role;
import com.hbpvu.jec.bookstore.account.repository.dao.UserRoleRelation;
@Service
public class RbacService implements UserDetailsService{
	@Autowired UserRepository userRepo;
	@Autowired UserRoleRepository urRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<MyUser> usero = userRepo.findById(username);
		if(!usero.isPresent())return null;
		MyUser user = usero.get();
		List<GrantedAuthority> as = new ArrayList<GrantedAuthority>();
		List<UserRoleRelation> roles = urRepo.findByUserId(username);
		for(UserRoleRelation r : roles) {
			GrantedAuthority p = new SimpleGrantedAuthority(r.getRoleId());
			as.add(p);
		}
		GrantedAuthority p = new SimpleGrantedAuthority("ADMIN_USER");
		as.add(p);
		p = new SimpleGrantedAuthority("STANDARD_USER");
		as.add(p);
		User rst = new User(username, user.getPassword(),as );
		return rst;
		
	}

}
