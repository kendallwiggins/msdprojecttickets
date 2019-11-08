package com.bah.msd.mcc.service;

import java.util.List;

import com.bah.msd.mcc.domain.Customer;

public interface CustomerService {

		List<Customer> findAll();
		Customer findByName(String name);
		
	}
