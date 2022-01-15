package com.hbpvu.jec.bookstore.order.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import com.hbpvu.jec.bookstore.commons.util.DateAudit;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends DateAudit {

    @Id

    private String cartId;

    @NotEmpty
    @NotNull

    private String userName;
    
    @Transient
    private List<CartItem> cartItems = new ArrayList<>();

    private double totalPrice;

    public void dismissChild(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }

}
