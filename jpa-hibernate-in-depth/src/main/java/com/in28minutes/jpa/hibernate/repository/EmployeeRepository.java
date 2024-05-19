package com.in28minutes.jpa.hibernate.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.entity.PartTimeEmployee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
	
	/*public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	public List<Employee> retrieveAllEmployees(){
		return entityManager.createQuery("select e from Employee e",Employee.class).getResultList();
	}*/
	public void insertPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
		entityManager.persist(partTimeEmployee);
	}
	public List<PartTimeEmployee> retrievePartTimeEmployees(){
		return entityManager.createQuery("select e from PartTimeEmployee e",PartTimeEmployee.class).getResultList();
	}
	public void insertFullTimeEmployee(FullTimeEmployee fullTimeEmployee) {
		entityManager.persist(fullTimeEmployee);
	}
	public List<FullTimeEmployee> retrieveFullTimeEmployee(){
		return entityManager.createQuery("select e from FullTimeEmployee e",FullTimeEmployee.class).getResultList();
	}
}
