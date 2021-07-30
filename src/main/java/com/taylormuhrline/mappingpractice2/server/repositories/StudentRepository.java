package com.taylormuhrline.mappingpractice2.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taylormuhrline.mappingpractice2.server.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
