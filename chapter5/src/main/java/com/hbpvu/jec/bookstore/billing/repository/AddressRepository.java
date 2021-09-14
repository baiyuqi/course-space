package com.hbpvu.jec.bookstore.billing.repository;

import org.springframework.data.repository.CrudRepository;

import com.hbpvu.jec.bookstore.billing.repository.dao.AddressDao;

import java.util.List;
import java.util.Optional;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-09-20
 */
public interface AddressRepository extends CrudRepository<AddressDao, String> {

    Optional<List<AddressDao>> findByUserId(String userId);

    Optional<AddressDao> findByAddressId(String addressId);

    Boolean existsByUserId(String userId);
    
}
