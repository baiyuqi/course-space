package com.hbpvu.jec.bookstore.account.service;

import com.hbpvu.jec.bookstore.account.web.CreateOAuthClientRequest;
import com.hbpvu.jec.bookstore.account.web.CreateOAuthClientResponse;
import com.hbpvu.jec.bookstore.account.web.CreateUserResponse;
import com.hbpvu.jec.bookstore.account.web.SignInRequest;
import com.hbpvu.jec.bookstore.account.web.SignUpRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
