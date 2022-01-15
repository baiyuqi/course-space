package com.hbpvu.jec.bookstore.payment.service;

import java.util.List;

import com.hbpvu.jec.bookstore.payment.web.CreatePaymentMethodRequest;
import com.hbpvu.jec.bookstore.payment.web.GetPaymentMethodResponse;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
