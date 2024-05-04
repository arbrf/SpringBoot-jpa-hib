package com.in28minutes.database.databasedemo;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepository personJpaRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("\n find  users with id {}",personJpaRepository.findById(10001));
		logger.info("\n insert  users with id 10004 {}",personJpaRepository.InsertBy(new Person("David","Ice Land","2000-10-28 09:45:00")));
		logger.info("\n update  users with id 10003 {}",personJpaRepository.updateBy(new Person("Charlie","LosVegas","1995-03-10 14:15:00")));
		personJpaRepository.deleteById(10003);
		logger.info("\n find all xxxx users {}",personJpaRepository.findAll());
		/*
		
		logger.info("\n find name users with name {}",personJdbcDao.findName("Alice"));
		logger.info("\n find  users with location {}",personJdbcDao.findLocation("Los Angeles"));
		logger.info("\n delete  users with id 10002 {}",personJdbcDao.deleteById(10002));
		*/
		
	}

}
