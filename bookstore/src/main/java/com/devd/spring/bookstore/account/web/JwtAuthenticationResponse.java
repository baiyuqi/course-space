package com.devd.spring.bookstore.account.web;

import lombok.Value;

/**
 * @author devaraj.reddy
 */
@Value
public class JwtAuthenticationResponse {

  private String access_token;
  private String token_type = "Bearer";
  private String refresh_token;
  private Long expires_in;
}
