package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional

public class PersonJpaRepository {
	@PersistenceContext
	EntityManager entityManager;
	public List<Person> findAll(){
		TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
		return createNamedQuery.getResultList();
		}
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	 public Person InsertBy(Person person) {
		    return entityManager.merge(person);
		    }
	 public Person updateBy(Person person) {
		 return entityManager.merge(person);
		}
	 public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	   }
}
