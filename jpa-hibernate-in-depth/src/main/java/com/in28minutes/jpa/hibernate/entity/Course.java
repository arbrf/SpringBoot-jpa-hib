package com.in28minutes.jpa.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	public Course() {}

	public Course(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return  name;
	}
	
	
	
}
