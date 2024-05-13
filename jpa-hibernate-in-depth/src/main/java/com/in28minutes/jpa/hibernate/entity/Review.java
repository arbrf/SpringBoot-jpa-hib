package com.in28minutes.jpa.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name = "description")
    private String description;
    private String rating;
    public Review() {}

    public Review(String description,String rating) {
        this.description = description;
        this.rating=rating;
    }

    public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public long getId() {
        return id;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return String.format("Rating[id=%d, description=%s]", rating, description);
    }
}
