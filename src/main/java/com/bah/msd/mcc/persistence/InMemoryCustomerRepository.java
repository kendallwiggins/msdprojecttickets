package com.bah.msd.mcc.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bah.msd.mcc.domain.Customer;

@Component
public class InMemoryCustomerRepository  {

	List<Customer> customerList = new ArrayList<>();

	public InMemoryCustomerRepository() {
		// initialize seed data
		this.initizalizeCustomers();
	}

	public void initizalizeCustomers() {
		this.customerList.add(new Customer("Fox", "fox@bah.com", "foxy"));
		this.customerList.add(new Customer("Kendall", "kendall@bah.com", "password"));
		this.customerList.add(new Customer("Greg", "greg@bah.com", "birthday"));
	}

	public List<Customer> findAll() {
		return customerList;
	}

	public Customer findByName(String name) {
		Optional<Customer> customerOptional = this.customerList.stream()
				.filter(customer -> customer.getName().equalsIgnoreCase(name)).findAny();

		return customerOptional.get();
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}
