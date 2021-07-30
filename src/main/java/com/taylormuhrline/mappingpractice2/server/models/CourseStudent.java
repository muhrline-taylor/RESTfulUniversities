package com.taylormuhrline.mappingpractice2.server.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="course_student")
public class CourseStudent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@OneToMany(mappedBy="course_student", fetch=FetchType.LAZY)
//	@JsonManagedReference
//	private List<Course> courses;
//	
//	@OneToMany(mappedBy="course_student", fetch=FetchType.LAZY)
//	@JsonManagedReference
//	private List<Student> students;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

}
