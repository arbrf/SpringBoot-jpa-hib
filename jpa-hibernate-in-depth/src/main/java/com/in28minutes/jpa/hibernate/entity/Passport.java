package com.in28minutes.jpa.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name = "passport_number", nullable = false)
    private String passportNumber;
    @OneToOne(mappedBy = "passport")
    private Student student;
    public Passport() {}

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public long getId() {
        return id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    
    
    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
    public String toString() {
        return String.format("Passport[%s]",passportNumber);
    }
}
