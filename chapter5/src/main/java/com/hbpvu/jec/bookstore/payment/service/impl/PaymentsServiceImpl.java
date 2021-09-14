package com.hbpvu.jec.bookstore.payment.service.impl;

import com.hbpvu.jec.bookstore.commons.exception.RunTimeExceptionPlaceHolder;
import com.hbpvu.jec.bookstore.payment.repository.UserPaymentCustomerRepository;
import com.hbpvu.jec.bookstore.payment.repository.dao.UserPaymentCustomer;
import com.hbpvu.jec.bookstore.payment.service.PaymentsService;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentRequest;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private UserPaymentCustomerRepository userPaymentCustomerRepository;

    @Override
    public CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest) {

       
     
            CreatePaymentResponse createPaymentResponse = new CreatePaymentResponse();

                return createPaymentResponse;
          

    }
}
