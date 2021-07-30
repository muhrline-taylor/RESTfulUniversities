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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(
		name="universities",
		uniqueConstraints = @UniqueConstraint(
					name="name_unique",
					columnNames="name"
				)
)
public class University {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@OneToMany(mappedBy="university", fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Student> students;
	
	@OneToMany(mappedBy="university", fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Instructor> instructors;
	
	@OneToMany(mappedBy="university", fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Course> courses;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    
    // CONSTRUCTORS ============================================= //
    
	public University() {
		super();
	}
	public University(String name) {
		super();
		this.name = name;
	}
	
	
	
	// GETTERS AND SETTERS ========================================= //
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public List<Instructor> getInstructors() {
		return instructors;
	}
	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
