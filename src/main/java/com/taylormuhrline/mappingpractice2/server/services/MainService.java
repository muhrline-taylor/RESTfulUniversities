package com.taylormuhrline.mappingpractice2.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taylormuhrline.mappingpractice2.server.models.Course;
import com.taylormuhrline.mappingpractice2.server.models.Instructor;
import com.taylormuhrline.mappingpractice2.server.models.Student;
import com.taylormuhrline.mappingpractice2.server.models.University;
import com.taylormuhrline.mappingpractice2.server.models.User;
import com.taylormuhrline.mappingpractice2.server.repositories.CourseRepository;
import com.taylormuhrline.mappingpractice2.server.repositories.InstructorRepository;
import com.taylormuhrline.mappingpractice2.server.repositories.StudentRepository;
import com.taylormuhrline.mappingpractice2.server.repositories.UniversityRepository;
import com.taylormuhrline.mappingpractice2.server.repositories.UserRepository;

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
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
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
	
	// DELETE UNIVERSITY
	public void deleteUniversity(Long university_id) {
		try {
			
			University university = universityRepository.getById(university_id);
			
			university.setCourses(null);
			university.setInstructors(null);
			university.setStudents(null);
			
			universityRepository.delete(university);
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("University must not have associated students, instructors, or courses before it can be deleted");
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
	
	// DELETE STUDENT
	public void deleteStudent(Long student_id) {
		
		try {
			
			Student student = studentRepository.getById(student_id);
			student.setCourses(null);
			student.setUniversity(null);
			
			studentRepository.delete(student);
			
		}catch(Exception e) {
			System.out.println(e);
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
	
	// DELETE INSTRUCTOR
	public void deleteInstructor(Long instructor_id) {
		try {

			Instructor instructor = instructorRepository.getById(instructor_id);
			
			instructor.setUniversity(null);
			instructor.setCourses(null);
			
			instructorRepository.delete(instructor);
			
			
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("Instructor cannot be deleted while mapped to a course. Please remove instructor from course.");
		}
	}
	
	
	
	// ============================== COURSE SERVICES =========================================== //
	
	// GET ALL
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	// CREATE
	public ResponseEntity<Course> createCourse(String course_name, Long instructor_id, Long university_id){
		
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
	

	
	// DELETE COURSE
	public void deleteCourse(Long course_id) {
		try {
			Course course = courseRepository.getById(course_id);
			System.out.println(course.getUniversity());
			
			course.setUniversity(null);
			course.setInstructor(null);
			course.setStudents(null);

			courseRepository.delete(course);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	
	// ================================== USER SERVICES ================================================ //
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	// ------ U N F I N I S H E D -----email validation issue----- //
	public ResponseEntity<User> createUser(
				String username,
				String password,
				String email
			) {
		
		System.out.println("into mainService.createUser");
		
		try {
			User newUser = new User(
					username,
					password,
					email
				);
			
			User savedUser = userRepository.save(newUser);
			
			return ResponseEntity.ok(savedUser);
			
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.unprocessableEntity().build();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	// ================================== MISC SERVICES ================================================ //
	
	// ADD STUDENT TO COURSE
	public ResponseEntity<Course> addStudentToCourse(Long student_id, Long course_id){
		
		try {
			Student student = studentRepository.getById(student_id);
			Course course = courseRepository.getById(course_id);
			
			course.getStudents().add(student);
			Course savedCourse = courseRepository.save(course);
			
			return ResponseEntity.ok(savedCourse);
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	
	
	

}
