package com.in28minutes.jpa.hibernate.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries(value = {
	    @NamedQuery(name = "query_get_all_course", query = "select c from Course c"),
	    @NamedQuery(name = "query_get_100_step_courses", query = "select c from Course c where c.name like '%100 steps'")
	})

public class Course {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "name",nullable = false,insertable = true)
	private String name;
	@CreationTimestamp
	private LocalDate created_Date;
	@UpdateTimestamp
	private LocalDate updated_Date;
	@OneToMany(mappedBy = "course")
	private List<Review> reviews;
	
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
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}
	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}
	@Override
	public String toString() {
		return  name;
	}
	
	
	
}
