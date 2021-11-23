package com.hbpvu.jec.bookstore.billing.service;

import java.util.List;

import com.hbpvu.jec.bookstore.billing.web.CreateAddressRequest;
import com.hbpvu.jec.bookstore.billing.web.GetAddressResponse;
import com.hbpvu.jec.bookstore.billing.web.UpdateAddressRequest;

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
