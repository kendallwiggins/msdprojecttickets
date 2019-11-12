package com.bah.msd.mcc.domain;

import java.time.LocalDateTime;
//import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATIONS")

public class Registrations{

	@Column (name="EVENT_ID")
	long eventId;
	
	@Column (name="CUSTOMER_ID")
	long customerId; 
	
	String notes;
	
	@Column (name="REGISTRATION_DATE")
	LocalDateTime regDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;

	public Registrations(long eventId, long customerId, String notes, LocalDateTime regDate) {
		super();
		this.eventId = eventId;
		this.customerId = customerId;
		this.notes = notes;
		this.regDate = regDate;
	}

	// default constructor
	public Registrations() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

}
