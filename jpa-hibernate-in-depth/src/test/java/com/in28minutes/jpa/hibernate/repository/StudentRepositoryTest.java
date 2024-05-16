package com.in28minutes.jpa.hibernate.repository;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepthApplication;
import com.in28minutes.jpa.hibernate.entity.Course;
import com.in28minutes.jpa.hibernate.entity.Passport;
import com.in28minutes.jpa.hibernate.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    @Test
    void findById_studnet() {
        Student student = studentRepository.findById(20001);

        logger.info("The  Student is {}", student);
        logger.info("The passport for student is {}", student.getPassport());
    }

    @Test
    void someTest() {
        // Retrieve a student entity from the database
        studentRepository.understandingPersistenceContext();
    }

    @Test
    void retrieveStudentPassportDetails() {
        Student student = studentRepository.findById(20001);

        logger.info("The  Student is {}", student);
        logger.info("The passport for student is {}", student.getPassport());
    }

    @Test
    void retrievePassportAssociatedStudentDetails() {
        Passport passport = entityManager.find(Passport.class, 30001);
        Student student = passport.getStudent();
        logger.info("The passport is {}", passport);
        logger.info("The student for student is {}", student);
    }
    @Test
    @Transactional
    void retrieveStudentAssociatedCourses() {
    	Student student = entityManager.find(Student.class, 20001);
    	logger.info("Student {}",student);
        logger.info("The retrieveStudentAssociatedCourses is {}",student.getCourses());
    }
}
