package com.hbpvu.jec.bookstore.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.order.repository.dao.Cart;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-07-08
 */
@Transactional
public interface CartRepository extends MongoRepository<Cart, String> {

    Cart findCartByUserName(String userName);

    Optional<Cart> findByCartId(String cartId);
}
