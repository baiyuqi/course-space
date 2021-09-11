package com.devd.spring.bookstore.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devd.spring.bookstore.payment.repository.dao.UserPaymentCustomer;

/**
 * @author Devaraj Reddy, Date : 14-Dec-2020
 */
@Repository
public interface UserPaymentCustomerRepository extends JpaRepository<UserPaymentCustomer, String> {

    UserPaymentCustomer findByUserId(String userId);
}
