package com.devd.spring.bookstore.account.service;

import com.devd.spring.bookstore.account.web.CreateOAuthClientRequest;
import com.devd.spring.bookstore.account.web.CreateOAuthClientResponse;
import com.devd.spring.bookstore.account.web.CreateUserResponse;
import com.devd.spring.bookstore.account.web.SignInRequest;
import com.devd.spring.bookstore.account.web.SignUpRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
