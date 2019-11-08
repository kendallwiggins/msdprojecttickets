package com.bah.msd.mcc.persistence;

//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.bah.msd.mcc.domain.Registrations;

public interface RegistrationRepository extends CrudRepository<Registrations, Long> {
	
	//public Optional<Events> findByName(String name);
}
