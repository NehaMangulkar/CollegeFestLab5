package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.demo.model.Student;

@Component
public class StudentDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//Add student
	@Transactional
	public void addStudent(Student student)
	{
		hibernateTemplate.save(student);
	}
	
	//get all students
	public List<Student> getAllStud()
	{
		return hibernateTemplate.loadAll(Student.class);
	}
	
	//get student by id
	public Student getStudentById(int id)
	{
		return hibernateTemplate.get(Student.class, id);
	}
	
	//Update Student
	@Transactional
	public void updateStud(Student stud)
	{
		hibernateTemplate.update(stud);
	}
	
	//delete Student
	@Transactional
	public void deleteStud(int id)
	{
		hibernateTemplate.delete(hibernateTemplate.load(Student.class,id));
	}

}
