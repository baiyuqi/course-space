package com.devd.spring.bookstore.account.service;

import com.devd.spring.bookstore.account.web.MapRoleToUsersRequest;
import com.devd.spring.bookstore.account.web.MapUserToRolesRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface UserRoleService {

  void mapUserToRoles(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void removeRolesFromUser(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void mapRoleToUsers(String roleName, MapRoleToUsersRequest mapRoleToUsersRequest);
}
