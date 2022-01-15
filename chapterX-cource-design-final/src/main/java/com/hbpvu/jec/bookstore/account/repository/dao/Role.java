package com.hbpvu.jec.bookstore.account.repository.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hbpvu.jec.bookstore.commons.util.DateAudit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

/**
 * @author: Devaraj Reddy, Date : 2019-05-17
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends DateAudit {

  @Id

  private String id;


  private String roleName;



  private String roleDescription;



}
