package com.uni.thesis.entity;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private String neptun_code;
    private String student_name;
    private String github_username;

    public String getNeptun_code() {
        return neptun_code;
    }

    public void setNeptun_code(String neptun_code) {
        this.neptun_code = neptun_code;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getGithub_username() {
        return github_username;
    }

    public void setGithub_username(String github_username) {
        this.github_username = github_username;
    }

}
