package com.bah.msd.mcc.persistence;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.bah.msd.mcc.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public Optional<Customer> findByName(String name);
}
