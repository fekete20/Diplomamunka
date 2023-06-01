package com.uni.thesis.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uni.thesis.entity.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, String> {

}
