package com.hbpvu.jec.bookstore.account.web;

import java.util.Set;

import com.hbpvu.jec.bookstore.account.repository.dao.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Devaraj Reddy, Date : 2019-10-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponse {

  private String userId;
  private String userName;
  private String firstName;
  private String lastName;
  private String email;
  private Set<Role> roles;

}
