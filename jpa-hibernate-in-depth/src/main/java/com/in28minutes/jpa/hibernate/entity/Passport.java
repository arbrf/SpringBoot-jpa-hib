package com.in28minutes.jpa.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name = "passport_number", nullable = false)
    private String passportNumber;
    
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
    
    @Override
    public String toString() {
        return String.format("Passport[%s]",passportNumber);
    }
}
