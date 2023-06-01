package com.uni.thesis.service;

import com.uni.thesis.dao.ResultDao;
import com.uni.thesis.dao.StudentDao;
import com.uni.thesis.entity.Result;
import com.uni.thesis.entity.Student;
import com.uni.thesis.entity.StudentAndResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkingService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    ResultDao resultDao;

    public List<StudentAndResult> linker() {
        List<Student> studentList = (List<Student>) studentDao.findAll();
        List<Result> resultList = (List<Result>) resultDao.findAll();


        List<StudentAndResult> commonList = new ArrayList<>();

        for (Student student : studentList) {
            for (Result result : resultList) {
                if(student.getGithub_username().equals(result.getGithub_username())) {
                    commonList.add(new StudentAndResult
                            (
                                    student.getNeptun_code(),
                                    student.getStudent_name(),
                                    student.getGithub_username(),
                                    result.getAssignment_name(),
                                    result.getAssignment_url(),
                                    result.getStarter_code_url(),
                                    result.getRoster_identifier(),
                                    result.getStudent_repository_name(),
                                    result.getStudent_repository_url(),
                                    result.getSubmission_timestamp(),
                                    result.getPoints_awarded(),
                                    result.getPoints_available()
                            )
                    );
                }
            }
        }
        return commonList;
    }
}
