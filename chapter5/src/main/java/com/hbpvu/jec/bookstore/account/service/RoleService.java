package com.hbpvu.jec.bookstore.account.service;

import java.util.List;

import com.hbpvu.jec.bookstore.account.repository.dao.Role;
import com.hbpvu.jec.bookstore.account.web.CreateRoleRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface RoleService {

  String createRole(CreateRoleRequest createRoleRequest);

  List<Role> getAllRoles();
}
