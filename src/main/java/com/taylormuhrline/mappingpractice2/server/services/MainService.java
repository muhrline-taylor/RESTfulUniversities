package com.taylormuhrline.mappingpractice2.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taylormuhrline.mappingpractice2.server.models.Course;
import com.taylormuhrline.mappingpractice2.server.models.Instructor;
import com.taylormuhrline.mappingpractice2.server.models.Student;
import com.taylormuhrline.mappingpractice2.server.models.University;
import com.taylormuhrline.mappingpractice2.server.repositories.CourseRepository;
import com.taylormuhrline.mappingpractice2.server.repositories.InstructorRepository;
import com.taylormuhrline.mappingpractice2.server.repositories.StudentRepository;
import com.taylormuhrline.mappingpractice2.server.repositories.UniversityRepository;

@Service
public class MainService {
	
	@Autowired
	private UniversityRepository universityRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	
	// ============================== UNIVERSITY SERVICES =========================================== //
	
	// GET ALL
	public List<University> getAllUniversities(){
		return universityRepository.findAll();
	}
	
	// CREATE
	public ResponseEntity<University> createUniversity(String name){
		
		try {
			University newUniversity = new University(name);
			University savedUniversity = universityRepository.save(newUniversity);
			return ResponseEntity.ok(savedUniversity);
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	
	
	
	
	
	
	// ============================== STUDENT SERVICES =========================================== //
	
	// GET ALL
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	// CREATE
	public ResponseEntity<Student> createStudent(String fname, String lname, Long university_id){
		
		try {
			University university = universityRepository.getById(university_id);
			Student newStudent = new Student(
						fname,
						lname,
						university
					);
			Student savedStudent = studentRepository.save(newStudent);
			return ResponseEntity.ok(savedStudent);
			
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	
	
	
	
	// ============================== INSTRUCTOR SERVICES =========================================== //
	
	// GET ALL
	public List<Instructor> getAllInstructors(){
		return instructorRepository.findAll();
	}
	
	// CREATE
	public ResponseEntity<Instructor> createInstructor(String fname, String lname, Long university_id){
		
		try {
			University university = universityRepository.getById(university_id);
			Instructor newInstructor = new Instructor(
						fname,
						lname,
						university
					);
			Instructor savedInstructor = instructorRepository.save(newInstructor);
			return ResponseEntity.ok(savedInstructor);
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.unprocessableEntity().build();
		}
		
	}
	
	
	
	// ============================== COURSE SERVICES =========================================== //
	
	// GET ALL
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	// CREATE
	public ResponseEntity<Course> createCourse(String course_name, Long instructor_id, Long university_id){
		
		System.out.println("into mainService.createCourse");
		
		
		try {
			Instructor instructor = instructorRepository.getById(instructor_id);
			University university = universityRepository.getById(university_id);
			Course newCourse = new Course(course_name, instructor, university);
			Course savedCourse = courseRepository.save(newCourse);
			return ResponseEntity.ok(savedCourse);
			
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	// ADD STUDENT
	public ResponseEntity<Course> addStudentToCourse(Long student_id, Long course_id){
		System.out.println("into mainService.addSTudentToCourse");
		
		try {
			Student student = studentRepository.findById(student_id).orElse(null);
			Course course = courseRepository.findById(course_id).orElse(null);
			
			course.getStudents().add(student);
			Course savedCourse = courseRepository.save(course);
			
			return ResponseEntity.ok(savedCourse);
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	
	
	

}
