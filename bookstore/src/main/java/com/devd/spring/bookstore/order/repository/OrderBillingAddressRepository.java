package com.devd.spring.bookstore.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.devd.spring.bookstore.order.repository.dao.OrderBillingAddress;

/**
 * @author Devaraj Reddy, Date : 07-Dec-2020
 */
public interface OrderBillingAddressRepository extends CrudRepository<OrderBillingAddress, String> {
    OrderBillingAddress findByOrderId(String orderId);
}
