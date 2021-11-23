package com.hbpvu.jec.bookstore.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.order.repository.dao.Order;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-09-18
 */
public interface OrderRepository extends CrudRepository<Order, String> {

    Order findByOrderId(String orderId);

    List<Order> findByUserId(String userId);
}
