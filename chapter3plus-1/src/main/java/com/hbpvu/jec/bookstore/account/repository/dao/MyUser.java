package com.hbpvu.jec.bookstore.account.repository.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hbpvu.jec.bookstore.order.repository.dao.Cart;
import com.hbpvu.jec.bookstore.order.repository.dao.CartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MyUser {
	@Id
	String name;
	String password;
	String email;
	String description;
	

}
