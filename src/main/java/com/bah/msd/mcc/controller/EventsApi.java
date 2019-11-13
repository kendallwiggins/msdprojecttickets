package com.bah.msd.mcc.controller;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.bah.msd.mcc.domain.Events;
import com.bah.msd.mcc.persistence.EventsRepository;

@RestController
@RequestMapping("/events")
public class EventsApi {

	// private final static String JSON = "application/JSON";

	@Autowired
	EventsRepository eventsRepo;

	// get a list of all events
	// URL: http://localhost:8080/api/events

	//@GetMapping("/all") // need to add produces = "JSON"?
	@GetMapping // changed to match URL of front end
	public Iterable<Events> getAllEvents() {
		System.out.println("This is a test to see if get all events worked!");
		return eventsRepo.findAll();
	}

//	// Return info for specific customer through their name
//	// URL: http://localhost:8080/customers/name
//
//	  @GetMapping("/name/{customerName}") 
//	  public Optional<Customer> findByName(@PathVariable("customerName") String customerName) {
//		  System.out.println("This is a test to see if get by name worked!"); 
//		  return eventsRepo.findByName(customerName); 
//
//		} 

	// get an event's info by its id
	// URL: http://localhost:8080/api/events/{event id number}

	@GetMapping("/{eventId}")
	public Optional<Events> findById(@PathVariable("eventId") long id) {
		System.out.println("This is a test to see if get event by id worked!");
		return eventsRepo.findById(id); // this is built-in in CRUD repository; do not need to add to
											// CustomerRepository.java
	}

	// add and save a new event
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Events newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 
				|| newEvent.getCode() == null
				|| newEvent.getTitle() == null 
				|| newEvent.getDescription() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		newEvent = eventsRepo.save(newEvent); // save is part of CRUD repository
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	// Update existing event by ID
	@PutMapping("/{eventId}")
	public ResponseEntity<?> putEvent(@RequestBody Events priorEvent,
			@PathVariable("eventId") long eventId) {
		if (priorEvent.getId() != eventId 
				|| priorEvent.getCode() == null
				|| priorEvent.getTitle() == null 
				|| priorEvent.getDescription() == null) {
			return ResponseEntity.badRequest().build();
		}
		priorEvent = eventsRepo.save(priorEvent); // save is part of CRUD repository
		return ResponseEntity.ok().build();
	}

//	// Update existing customer by name
//	@PutMapping("/name/{customerName}")
//	public ResponseEntity<?> putCustomerName(@RequestBody Customer newCustomer,
//			@PathVariable("customerName") String customerName) {
//		if (newCustomer.getName() == null || newCustomer.getEmail() == null) {
//			return ResponseEntity.badRequest().build();
//		}
//		newCustomer = eventsRepo.save(newCustomer); // save is part of CRUD repository
//		return ResponseEntity.ok().build();
//	}
	
	// Delete an existing customer by ID; remove RequestBody to not need info in Body in Postman?
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEvent(@RequestBody Events delEvent, @PathVariable Long id) {
		if (delEvent.getId() != id 
				|| delEvent.getCode() == null 
				|| delEvent.getTitle() == null
				|| delEvent.getDescription() == null){
			return ResponseEntity.badRequest().build();
		}
		eventsRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
//	// Delete an existing customer by name
//		@DeleteMapping("/name/{customerName}")
//		public ResponseEntity<?> deleteCustomerName(@RequestBody Customer delCustomer, @PathVariable String customerName) {
//			if (delCustomer.getName() == null 
//				|| delCustomer.getEmail() == null) {
//				return ResponseEntity.badRequest().build();
//			}
//			eventsRepo.delete(delCustomer); 
//			return ResponseEntity.ok().build();
//		}
}
