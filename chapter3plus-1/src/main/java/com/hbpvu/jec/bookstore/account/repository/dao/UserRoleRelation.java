package com.hbpvu.jec.bookstore.account.repository.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleRelation {
	@Id
	String id;
	String userId;
	String roleId;

}
