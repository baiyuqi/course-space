package com.hbpvu.jec.bookstore.payment.service.impl;

import com.hbpvu.jec.bookstore.commons.exception.RunTimeExceptionPlaceHolder;
import com.hbpvu.jec.bookstore.payment.repository.UserPaymentCustomerRepository;
import com.hbpvu.jec.bookstore.payment.repository.dao.UserPaymentCustomer;
import com.hbpvu.jec.bookstore.payment.service.PaymentMethodService;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentMethodRequest;
import com.hbpvu.jec.bookstore.payment.web.GetPaymentMethodResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
@Service
@Slf4j
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private UserPaymentCustomerRepository userPaymentCustomerRepository;

    public PaymentMethodServiceImpl() {
    }

    @Override
    public void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest) {


    }

    @Override
    public List<GetPaymentMethodResponse> getAllMyPaymentMethods() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = authentication.getName();

        List<GetPaymentMethodResponse> list = new ArrayList<>();

     

        return list;
    }

    @Override
    public GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken =authentication.getName();

            GetPaymentMethodResponse getPaymentMethodResponse = GetPaymentMethodResponse.builder()
                  
                    .build();
            return getPaymentMethodResponse;
      
    }


}
