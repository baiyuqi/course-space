package com.devd.spring.bookstore.billing.service;

import java.util.List;

import com.devd.spring.bookstore.billing.web.CreateAddressRequest;
import com.devd.spring.bookstore.billing.web.GetAddressResponse;
import com.devd.spring.bookstore.billing.web.UpdateAddressRequest;

/**
 * @author: Devaraj Reddy, Date : 2019-09-27
 */
public interface AddressService {

  void createAddress(CreateAddressRequest createAddressRequest);

  List<GetAddressResponse> getAddress();

  void updateAddress(UpdateAddressRequest updateAddressRequest);

  GetAddressResponse getAddressById(String addressId);

  void deleteAddressById(String addressId);
}
