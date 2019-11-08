package com.bah.msd.mcc.domain;

import java.util.Date;

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
	int eventId;
	int customerId; 
	String notes;
	Date regDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;

	public Registrations(int eventId, int customerId, String notes, Date regDate) {
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

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
