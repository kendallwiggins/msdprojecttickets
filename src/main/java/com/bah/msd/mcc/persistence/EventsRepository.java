package com.bah.msd.mcc.persistence;

//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.bah.msd.mcc.domain.Events;

public interface EventsRepository extends CrudRepository<Events, Long> {
	
	//public Optional<Events> findByName(String name);
}
