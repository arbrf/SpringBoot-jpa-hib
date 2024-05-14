package com.in28minutes.jpa.hibernate.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name = "description")
    private String description;
    private String rating;
    @ManyToOne
    private Course course;
    public Review() {}

    public Review(String rating,String description) {
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
    
    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	 public static List<Review> asListOf(Review... reviews) {
	        return Arrays.asList(reviews);
	    }
	@Override
    public String toString() {
        return String.format("Rating[id=%d, description=%s]", rating, description);
    }
}
