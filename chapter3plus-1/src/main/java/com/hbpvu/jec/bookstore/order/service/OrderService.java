package com.hbpvu.jec.bookstore.order.service;

import java.util.List;

import com.hbpvu.jec.bookstore.order.web.CreateOrderRequest;
import com.hbpvu.jec.bookstore.order.web.CreateOrderResponse;
import com.hbpvu.jec.bookstore.order.web.PreviewOrderRequest;
import com.hbpvu.jec.bookstore.order.web.PreviewOrderResponse;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-09-20
 */
public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    PreviewOrderResponse previewOrder(PreviewOrderRequest previewOrderRequest);

    CreateOrderResponse getOrderById(String orderId);

    List<CreateOrderResponse> getMyOrders();

    List<CreateOrderResponse> getAllOrders();
}
