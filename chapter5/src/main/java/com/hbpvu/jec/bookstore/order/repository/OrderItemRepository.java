package com.hbpvu.jec.bookstore.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.order.repository.dao.OrderItem;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-09-18
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
}
