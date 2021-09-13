package com.hbpvu.jec.bookstore.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbpvu.jec.bookstore.account.service.AuthService;
import com.hbpvu.jec.bookstore.account.web.CreateOAuthClientRequest;
import com.hbpvu.jec.bookstore.account.web.CreateOAuthClientResponse;
import com.hbpvu.jec.bookstore.account.web.CreateUserResponse;
import com.hbpvu.jec.bookstore.account.web.SignUpRequest;

import javax.validation.Valid;

/**
 * @author: Devaraj Reddy, Date : 2019-05-18
 */
@RestController
@CrossOrigin
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping("/client")
  @PreAuthorize("hasAuthority('ADMIN_USER')")
  public ResponseEntity<CreateOAuthClientResponse> createOAuthClient(
      @Valid @RequestBody CreateOAuthClientRequest createOAuthClientRequest) {

    CreateOAuthClientResponse oAuthClient = authService.createOAuthClient(createOAuthClientRequest);
    return new ResponseEntity<>(oAuthClient, HttpStatus.CREATED);
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

    CreateUserResponse createUserResponse = authService.registerUser(signUpRequest);

    return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
  }
}
