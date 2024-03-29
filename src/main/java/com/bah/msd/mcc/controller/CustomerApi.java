package com.bah.msd.mcc.controller;

import java.net.URI;
//import java.util.Iterator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	// URL: http://localhost:8080/customers

	// @GetMapping("/all") // need to add produces = "JSON"?
	@GetMapping // changed to match URL of front end
	public Iterable<Customer> getAllCustomers() {
		System.out.println("This is a test to see if get all worked!");
		// System.out.println(this.customerRepo.findAll().toString());
		return customerRepo.findAll();
	}

	// Return info for specific customer through their name
	// URL: http://localhost:8080/api/customers/byname/{name}

	@PostMapping("/byname/{customername}")
	public boolean lookupCustomerByNameGet(@RequestBody Customer customer, @PathVariable String customername) {
		
		System.out.println("help");
		
		Optional<Customer> cust = customerRepo.findByName(customername);
		System.out.println(cust);
		
		if (cust.isPresent()) {
			//ResponseEntity<?> response = ResponseEntity.ok(cust.get());
			System.out.println("true");
			return true;
			
		}
		
		return false;
		
	}

	@GetMapping("/byname/{customerName}")
	public Optional<Customer> findByName(@PathVariable("customerName") String customerName) {
		System.out.println("This is a test to see if get by name worked!");
		return customerRepo.findByName(customerName);
	}

	// get a customer's info by their id
	// URL: http://localhost:8080/api/customers/{id number}

	@GetMapping("/{customerId}") // Post?
	public Optional<Customer> findById(@PathVariable("customerId") long id) {
		System.out.println("This is a test to see if get by id worked!");
		return customerRepo.findById(id); // this is built-in in CRUD repository; do not need to add to
											// CustomerRepository.java
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

	// Update existing customer by ID
	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer,
			@PathVariable("customerId") long customerId) {
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = customerRepo.save(newCustomer); // save is part of CRUD repository
		return ResponseEntity.ok().build();
	}

	// Update existing customer by name
	@PutMapping("/name/{customerName}")
	public ResponseEntity<?> putCustomerName(@RequestBody Customer newCustomer,
			@PathVariable("customerName") String customerName) {
		if (newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = customerRepo.save(newCustomer); // save is part of CRUD repository
		return ResponseEntity.ok().build();
	}

	// Delete an existing customer by ID; remove RequestBody to not need info in
	// Body in Postman?
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@RequestBody Customer delCustomer, @PathVariable Long id) {
		if (delCustomer.getId() != id || delCustomer.getName() == null || delCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		customerRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}

	// Delete an existing customer by name
	@DeleteMapping("/name/{customerName}")
	public ResponseEntity<?> deleteCustomerName(@RequestBody Customer delCustomer, @PathVariable String customerName) {
		if (delCustomer.getName() == null || delCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		customerRepo.delete(delCustomer);
		return ResponseEntity.ok().build();
	}
}
