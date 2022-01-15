package com.hbpvu.jec.bookstore.billing.repository.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import com.hbpvu.jec.bookstore.commons.util.DateAudit;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDao extends DateAudit {
    
    @Id

    private String addressId;
    

    private String userId;
    

    private String addressLine1;
    

    private String addressLine2;
    

    private String city;


    private String state;

    private String postalCode;
    
    @Pattern(regexp = "[A-Z]{2}", message = "2-letter ISO country code required")
    @NonNull
    private String country;

    private String phone;
}
