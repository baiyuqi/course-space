package com.hbpvu.jec.bookstore.payment.service;

import com.hbpvu.jec.bookstore.payment.web.CreatePaymentRequest;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentResponse;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
