package com.in28minutes.jpa.hibernate.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
	
	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	public List<Employee> retrieveAllEmployees(){
		return entityManager.createQuery("select e from Employee e",Employee.class).getResultList();
	}
}
