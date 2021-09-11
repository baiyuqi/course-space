package com.devd.spring.bookstore.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.devd.spring.bookstore.order.repository.dao.OrderItem;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-09-18
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
}
