package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.StudentService;
import com.demo.model.Student;
import org.springframework.ui.*;

@Controller
@RequestMapping
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//loading add student form
	@GetMapping("addStudent")
	public String addStud()
	{
		return "AddStudent";
	}
	//save student form
	@PostMapping("insertStudent")
	public String insertStudent(@ModelAttribute("insertStudent") Student stud)
	{
		studentService.addStud(stud);
		return "redirect:/studentReport";
	}
	
	//load student data 
	@GetMapping("studentReport")
	public String loadStudent(Model m)
	{
		m.addAttribute("student",studentService.getAllStud());
		m.addAttribute("title", "Student Report");
		
		return "StudentReport";
		
	}
	
	//load Edit form
	@GetMapping("editStudent/{id}")
	public String loadEditForm(@PathVariable(value ="id") int id, Model m)
	{
		Student stud = studentService.getById(id);
		m.addAttribute("student", stud);
		m.addAttribute("Title", "Edit Student");
		return "EditStudent";
	}
	
	@PostMapping("editStudent/updateStudent")
	public String updateStud(@ModelAttribute("updateStudent") Student stud)
	{
		studentService.updateStudent(stud);
		return "redirect:/studentReport";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStud(@PathVariable int id)
	{
		studentService.deleteStudent(id);
		return "redirect:/studentReport";
	}

}
