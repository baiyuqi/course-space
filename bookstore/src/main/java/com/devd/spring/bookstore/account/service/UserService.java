package com.devd.spring.bookstore.account.service;

import java.util.List;

import com.devd.spring.bookstore.account.web.CreateUserRequest;
import com.devd.spring.bookstore.account.web.GetUserInfoResponse;
import com.devd.spring.bookstore.account.web.GetUserResponse;
import com.devd.spring.bookstore.account.web.UpdateUserRequest;
import com.devd.spring.bookstore.account.web.UpdateUserRequestFromAdmin;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface UserService {

  String createUser(CreateUserRequest createUserRequest);

  GetUserResponse getUserByUserName(String userName);

  GetUserResponse getUserByUserId(String userId);

  GetUserInfoResponse getUserInfo();

  void updateUserInfo(UpdateUserRequest updateUserRequest);

  void deleteUserById(String userId);

  List<GetUserResponse> getAllUsers();

  void updateUser(String userId, UpdateUserRequestFromAdmin updateUserRequestFromAdmin);
}
