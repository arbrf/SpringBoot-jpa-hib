package com.in28minutes.jpa.hibernate.entity;

import org.hibernate.annotations.Fetch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "name",nullable = false)
	private String name;
	 @OneToOne(fetch = FetchType.LAZY)
	    private Passport passport;
	public Student() {}

	public Student(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Student[%s]",name) ;
	}
	
	
	
}
