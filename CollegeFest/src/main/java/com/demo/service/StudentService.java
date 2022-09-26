package com.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDao;
import com.demo.model.Student;

@Component
@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	//Add student
	public void addStud(Student stud)
	{
		studentDao.addStudent(stud);
		
	}
	
	//get all Students
	public List<Student> getAllStud()
	{
		return studentDao.getAllStud();
	}
	
	//get Student by id
	public Student getById(int id)
	{
		return studentDao.getStudentById(id);
	}
	
	//update Student
	
	public void updateStudent(Student stud)
	{
		studentDao.updateStud(stud);
	}
	
	//Delete delete student based on ID
	public void deleteStudent(int id)
	{
		studentDao.deleteStud(id);
	}

}
