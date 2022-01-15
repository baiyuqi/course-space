package com.hbpvu.jec.bookstore.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbpvu.jec.bookstore.payment.service.PaymentsService;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentRequest;
import com.hbpvu.jec.bookstore.payment.web.CreatePaymentResponse;

import javax.validation.Valid;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
@RestController
@Slf4j
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping("/pay")
    public ResponseEntity<?> doPayment(@RequestBody @Valid CreatePaymentRequest createPaymentRequest) {
        CreatePaymentResponse paymentRequest = paymentsService.createPaymentRequest(createPaymentRequest);
        return new ResponseEntity<>(paymentRequest, HttpStatus.CREATED);
    }

}
