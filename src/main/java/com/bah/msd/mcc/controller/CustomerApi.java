package com.bah.msd.mcc.controller;

import java.net.URI;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.msd.mcc.domain.Customer;
import com.bah.msd.mcc.persistence.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerApi {

	// private final static String JSON = "application/JSON";

	@Autowired
	CustomerRepository customerRepo;

	// get a list of all customers
	// URL: http://localhost:8080/customers/all
	
	@GetMapping("/all") // need to add produces = "JSON"
	public Iterable<Customer> getAllCustomers() {
		System.out.println("This is a test to see if get all worked!");
		//System.out.println(this.customerRepo.findAll().toString());
		return customerRepo.findAll();
	}

	// Return info for specific customer through their name
	// URL: http://localhost:8080/customers/name

	/*
	 * @GetMapping("/{customerName}") public Optional<Customer>
	 * findByName(@PathVariable("customerName") String customerName) {
	 * System.out.println("This is a test to see if get by name worked!"); return
	 * this.customerRepo.findByName(customerName); }
	 */
	
	// get a customer's info by their id
	// URL: http://localhost:8080/customers/{id number}
	
	
	@GetMapping("/{customerId}")
	public Optional<Customer> findById(@PathVariable("customerId") long id) {
		System.out.println("This is a test to see if get by id worked!");
		return customerRepo.findById(id);	// this is built-in in CRUD repository; do not need to add to CustomerRepository.java
	}
	
	// add and save a new customer
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		if (newCustomer.getId() != 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = customerRepo.save(newCustomer); // save is part of CRUD repository
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}
}