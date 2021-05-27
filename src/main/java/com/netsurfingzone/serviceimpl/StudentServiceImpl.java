package com.netsurfingzone.serviceimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Student save(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.save(student);
		return student;
	}

	@Transactional
	public Student persist(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(student);

		// we can also do --but same doesn't apply for save() method
		// entityManager.persist(student);

		session.persist(student);
		return student;
	}

	@Transactional
	public Student retrieveEntity(Long id) {

		Session session = entityManager.unwrap(Session.class);
		Student student = session.load(Student.class, id);
		System.out.println("name is" + student.getName());
		return student;
	}

}
