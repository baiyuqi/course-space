package com.hbpvu.jec.bookstore.catalog.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrigin {
	String country;
	String province;
	String email;

}
