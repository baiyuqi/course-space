package com.hbpvu.jec.bookstore.order.repository.dao;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hbpvu.jec.bookstore.commons.util.DateAudit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-17
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem extends DateAudit {
    
    @Id

    private String cartItemId;


    private int quantity;

    private double itemPrice;


    private double extendedPrice;
    

    private String productId;

    private String productName;



    private String cartId;
    

    
    @Override
    public String toString() {
        return "CartItem{" +
                       "cartItemId='" + cartItemId + '\'' +
                       ", quantity=" + quantity +
                       ", itemPrice=" + itemPrice +
                       ", productId='" + productId + '\'' +
                       '}';
    }
}
