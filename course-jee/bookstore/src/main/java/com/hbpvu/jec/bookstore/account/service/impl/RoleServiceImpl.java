package com.hbpvu.jec.bookstore.account.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.account.repository.RoleRepository;
import com.hbpvu.jec.bookstore.account.repository.dao.Role;
import com.hbpvu.jec.bookstore.account.service.RoleService;
import com.hbpvu.jec.bookstore.account.web.CreateRoleRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-06-30
 */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleRepository roleRepository;


  @Override
  public String createRole(CreateRoleRequest createRoleRequest) {

    Role role = Role.builder()
        .roleName(createRoleRequest.getRoleName())
        .roleDescription(createRoleRequest.getRoleDescription())
        .build();

    Role savedRole = roleRepository.save(role);
    return savedRole.getId();
  }

  @Override
  public List<Role> getAllRoles() {
    List<Role> allRoles = roleRepository.findAll();
    return allRoles;
  }
}