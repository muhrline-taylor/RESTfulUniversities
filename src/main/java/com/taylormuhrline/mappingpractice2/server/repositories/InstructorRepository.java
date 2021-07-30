package com.taylormuhrline.mappingpractice2.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taylormuhrline.mappingpractice2.server.models.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
