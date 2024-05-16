package com.in28minutes.jpa.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(
		name ="STUDENT_COURSE",
		joinColumns = @JoinColumn(name="STUDENT_ID"),
		inverseJoinColumns = @JoinColumn(name="COURSE_ID")
			 )
	 private List<Course> courses = new ArrayList<>();
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
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
	public void removeCourse(Course course) {
		this.courses.remove(course);
	}
	@Override
	public String toString() {
		return String.format("Student[%s]",name) ;
	}
	
	
	
}
