package com.devd.spring.bookstore.payment.service;

import java.util.List;

import com.devd.spring.bookstore.payment.web.CreatePaymentMethodRequest;
import com.devd.spring.bookstore.payment.web.GetPaymentMethodResponse;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
