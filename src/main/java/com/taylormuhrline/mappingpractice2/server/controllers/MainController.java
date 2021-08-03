package com.taylormuhrline.mappingpractice2.server.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taylormuhrline.mappingpractice2.server.models.Course;
import com.taylormuhrline.mappingpractice2.server.models.Instructor;
import com.taylormuhrline.mappingpractice2.server.models.Student;
import com.taylormuhrline.mappingpractice2.server.models.University;
import com.taylormuhrline.mappingpractice2.server.services.MainService;

@RestController
@RequestMapping("/api/v1")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	
	// ====================================== ROUTES ===================================== //
	
	// GET ALL --------------------- //
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return mainService.getAllStudents();
	}	
	
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors(){
		return mainService.getAllInstructors();
	}
	
	@GetMapping("/universities")
	public List<University> getAllUniversities(){
		return mainService.getAllUniversities();
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return mainService.getAllCourses();
	}
	
	
	
	
	
	// CREATE ---------------------- //
	
	@PostMapping("/students/new")
	public void createStudent(@RequestBody Map<String, Object> payload) {
		
		try {
			mainService.createStudent(
					payload.get("fname").toString(),
					payload.get("lname").toString(),
					Long.parseLong(payload.get("university_id").toString())
					);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@PostMapping("/instructors/new")
	public void createInstructor(@RequestBody Map<String, Object> payload) {

		try {
			mainService.createInstructor(
						payload.get("fname").toString(),
						payload.get("lname").toString(),
						Long.parseLong(payload.get("university_id").toString())
					);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@PostMapping("/universities/new")
	public void createUniversity(@RequestBody Map<String, Object> payload) {
		try {
			mainService.createUniversity(payload.get("name").toString());
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@PostMapping("/courses/new")
	public void createCourse(@RequestBody Map<String, Object> payload) {
		try {
			mainService.createCourse(
						payload.get("name").toString(),
						Long.parseLong(payload.get("instructor_id").toString()),
						Long.parseLong(payload.get("university_id").toString())
					);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@PutMapping("/courses/addStudent")
	public void addStudentToCourse(@RequestBody Map<String, Object> payload) {
		try {
			mainService.addStudentToCourse(
						Long.parseLong(payload.get("student_id").toString()), 
						Long.parseLong(payload.get("course_id").toString())
					);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	// DELETE ------------------------------- //
	
	@DeleteMapping("/courses/delete")
	public void deleteCourse(@RequestBody Map<String, Object> payload) {
		try {
			mainService.deleteCourse(Long.parseLong(payload.get("course_id").toString()));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@DeleteMapping("/instructors/delete")
	public void deleteInstructor(@RequestBody Map<String, Object> payload) {
		try {
			mainService.deleteInstructor(Long.parseLong(payload.get("instructor_id").toString()));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@DeleteMapping("/students/delete")
	public void deleteStudent(@RequestBody Map<String, Object> payload) {
		try {
			mainService.deleteStudent(Long.parseLong(payload.get("student_id").toString()));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@DeleteMapping("/universities/delete")
	public void deleteUniversity(@RequestBody Map<String, Object> payload) {
		try {
			mainService.deleteUniversity(Long.parseLong(payload.get("university_id").toString()));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/courseStudents/new")
//	public void createCourseStudent(@RequestBody Map<String, Object> payload) {
//		try {
//			mainService.createCourseStudent(Long.parseLong(payload.get("student_id").toString()), Long.parseLong(payload.get("course_id").toString()));
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//	}
	
	
	
	
	
	
	
	
//	@PostMapping("/students/new")
//	public void createStudent() {
//		Student newStudent = new Student("taylor", "john", universityRepository.getById((long) 1));
//		studentRepository.save(newStudent);
//	}
	
	
	
			// TESTING //
//	@PostMapping("/instructors/new")
//	public void createInstructor() {
//		Instructor newInstructor = new Instructor("john", "taylor", universityRepository.getById((long) 1));
//		instructorRepository.save(newInstructor);
//	}
	
	
			// TESTING //
//	@PostMapping("/universities/new")
//	public void createUniversity() {
//		try {
//			University newUniversity = new University("Alternate Campus");
//			universityRepository.save(newUniversity);
//		} catch(Exception e) {
//			System.out.println(e);
//		}
//		
//	}
	
	
	
	
	
}
