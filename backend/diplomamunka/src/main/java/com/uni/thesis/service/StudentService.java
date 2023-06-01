package com.uni.thesis.service;

import java.util.List;

import com.uni.thesis.dao.StudentDao;
import com.uni.thesis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Student addStudent(Student student) {
        return studentDao.save(student);

    }

    public List<Student> getStudents() {
        return (List<Student>) studentDao.findAll();

    }

    public void deleteStudent(String id) {
        studentDao.deleteById(id);
    }

    public Student updateStudent(Student student) {
        String neptun_code = student.getNeptun_code();
        Student tempStudent = studentDao.findById(neptun_code).get();

        tempStudent.setStudent_name(student.getStudent_name());
        tempStudent.setGithub_username(student.getGithub_username());


        return studentDao.save(tempStudent);
    }
}
