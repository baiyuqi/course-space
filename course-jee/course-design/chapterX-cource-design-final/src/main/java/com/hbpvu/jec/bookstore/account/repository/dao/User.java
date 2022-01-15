package com.hbpvu.jec.bookstore.account.repository.dao;

import java.util.Set;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import com.hbpvu.jec.bookstore.commons.util.DateAudit;

/**
 * @author: Devaraj Reddy, Date : 2019-05-17
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class User extends DateAudit {


  Set<String> roles;
@Id
  private String userId;


  private String userName;


  private String password;


  private String firstName;


  private String lastName;

  private String email;

  public User(String userName, String password, String firstName, String lastName, String email) {
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
