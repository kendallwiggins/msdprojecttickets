package com.bah.msd.mcc.service;


import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bah.msd.mcc.domain.Customer;
import com.bah.msd.mcc.persistence.InMemoryCustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private InMemoryCustomerRepository customerRepo;
	
	public List<Customer> findAll() {
		return customerRepo.findAll();
	}
	
	public Customer findByName(String name) {
		return customerRepo.findByName(name);
	}
	
//	public void createCustomer(Customer newCustomer) {
//		customerRepo.getCustomerList().add(new Customer(newCustomer.getId(),newCustomer.getName(),newCustomer.getEmail(), newCustomer.getPassword()));
//	}
	
}
