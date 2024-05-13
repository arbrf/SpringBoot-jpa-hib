package com.in28minutes.jpa.hibernate.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.entity.Passport;
import com.in28minutes.jpa.hibernate.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	EntityManager entityManager;
	
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}
	public void deleteByID(int id) {
		Student student=findById(id);
		entityManager.remove(student);
	}
	
	public Student save(Student student) {
		Optional<Long> studentIdOptional = Optional.ofNullable(student.getId());

		if (!studentIdOptional.isPresent()) {
		    // StudentId is null
		    // Handle the case where StudentId is null
			entityManager.persist(student);
		} 		    
		else {
			entityManager.merge(student);
		}
		return student;

	}
	public void saveStudentwithPassword() {
		Passport passport=new Passport("M523146");
		entityManager.persist(passport);
		Student student=new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);
		
		
	}
	void understandingPersistenceContext() {
		Student student = entityManager.find(Student.class, 20001);
	    
	    // Retrieve the passport associated with the student
	    Passport passport = student.getPassport();
	    
	    // Update the passport number
	    passport.setPassportNumber("S123456");
	    
	    // Update the student's name
	    student.setName("Ranga -Updated!!!");
	    
	    // Log the updated student information
	    
	    // Log the passport information
	}
	
	

}
