package com.devd.spring.bookstore.payment.service;

import com.devd.spring.bookstore.payment.web.CreatePaymentRequest;
import com.devd.spring.bookstore.payment.web.CreatePaymentResponse;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
