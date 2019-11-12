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
import com.bah.msd.mcc.domain.Registrations;
import com.bah.msd.mcc.persistence.RegistrationsRepository;;

@RestController
@RequestMapping("/registrations")
public class RegistrationsApi {

	// private final static String JSON = "application/JSON";

	@Autowired
	RegistrationsRepository regRepo;

	// get a list of all registrations
	// URL: http://localhost:8080/api/registrations

	//@GetMapping("/all") // need to add produces = "JSON"?
	@GetMapping 
	public Iterable<Registrations> getAllReg() {
		System.out.println("This is a test to see if get all registrations worked!");
		return regRepo.findAll();
	}

	// get an registration's info by its id
	// URL: http://localhost:8080/api/registrations/{registration event id number}

	@GetMapping("/{regId}")
	public Optional<Registrations> findById(@PathVariable("regId") long id) {
		System.out.println("This is a test to see if get event by id worked!");
		return regRepo.findById(id); // this is built-in in CRUD repository; do not need to add to
											// CustomerRepository.java
	}

	// add and save a new registration
	@PostMapping
	public ResponseEntity<?> addReg(@RequestBody Registrations newReg, UriComponentsBuilder uri) {
		if (newReg.getId() != 0 
				|| newReg.getEventId() == 0
				|| newReg.getCustomerId() == 0
				|| newReg.getNotes() == null 
				|| newReg.getRegDate() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		newReg = regRepo.save(newReg); // save is part of CRUD repository
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newReg.getEventId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	// Update existing registration by ID
	@PutMapping("/{regId}")
	public ResponseEntity<?> putReg(@RequestBody Registrations priorReg,
			@PathVariable("regId") long regId) {
		if (priorReg.getId() != regId 
				|| priorReg.getEventId() == 0
				|| priorReg.getCustomerId() == 0
				|| priorReg.getNotes() == null 
				|| priorReg.getRegDate() == null) {
			return ResponseEntity.badRequest().build();
		}
		priorReg =regRepo.save(priorReg); // save is part of CRUD repository
		return ResponseEntity.ok().build();
	}

	// Delete an existing registration by ID; remove RequestBody to not need info in Body in Postman?
	@DeleteMapping("/{regId}")
	
	public ResponseEntity<?> deleteEvent(@RequestBody Registrations delReg, @PathVariable Long regId) {
		if (delReg.getId() != regId 
				|| delReg.getEventId() == 0
				|| delReg.getCustomerId() == 0 
				|| delReg.getNotes() == null
				|| delReg.getRegDate() == null){
			return ResponseEntity.badRequest().build();
		}
		regRepo.deleteById(regId);
		return ResponseEntity.ok().build();
	}
	
}
