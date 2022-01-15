package com.hbpvu.jec.bookstore.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.order.repository.dao.OrderShippingAddress;

/**
 * @author Devaraj Reddy, Date : 07-Dec-2020
 */
public interface OrderShippingAddressRepository extends CrudRepository<OrderShippingAddress, String> {
    OrderShippingAddress findByOrderId(String orderId);
}
