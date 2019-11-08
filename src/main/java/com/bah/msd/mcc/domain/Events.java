package com.bah.msd.mcc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVENTS")

public class Events{

	@Column (name="EVENT_CODE")
	String code;
	String title; 
	String description;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;

	public Events(String code, String title, String description) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
	}

	// default constructor
	public Events() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
