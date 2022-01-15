package com.hbpvu.jec.bookstore.order.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.order.repository.dao.CartItem;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-07-13
 */

public interface CartItemRepository extends MongoRepository<CartItem, String> {

    @Modifying
    @Transactional
    void deleteByCartItemId(String cartItemId);

    Optional<CartItem> findByCartItemId(String cartItemId);
    List<CartItem> findByCartId(String cartId);
}
