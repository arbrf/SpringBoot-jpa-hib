package com.in28minutes.database.databasedemo;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao personJdbcDao;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("\n find all users {}",personJdbcDao.findAll());
	}

}
