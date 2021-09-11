package com.devd.spring.bookstore.account.service;

import java.util.List;

import com.devd.spring.bookstore.account.repository.dao.Role;
import com.devd.spring.bookstore.account.web.CreateRoleRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface RoleService {

  String createRole(CreateRoleRequest createRoleRequest);

  List<Role> getAllRoles();
}
