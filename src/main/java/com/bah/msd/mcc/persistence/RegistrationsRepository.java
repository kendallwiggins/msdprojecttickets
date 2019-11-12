package com.bah.msd.mcc.persistence;

import org.springframework.data.repository.CrudRepository;
import com.bah.msd.mcc.domain.Registrations;

public interface RegistrationsRepository extends CrudRepository<Registrations, Long> {
	
}
