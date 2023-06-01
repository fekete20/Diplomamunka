package com.uni.thesis.entity;

public class StudentAndResult {
    //Student
    private String neptun_code;
    private String student_name;
    private String github_username;

    // Result
    private String assignment_name;
    private String assignment_url;
    private String starter_code_url;
    private String roster_identifier;
    private String student_repository_name;
    private String student_repository_url;
    private String submission_timestamp;
    private Integer points_awarded;
    private Integer points_available;

    @Override
    public String toString() {
        return "StudentAndResult{" +
                "neptun_code='" + neptun_code + '\'' +
                ", student_name='" + student_name + '\'' +
                ", github_username='" + github_username + '\'' +
                ", assignment_name='" + assignment_name + '\'' +
                ", assignment_url='" + assignment_url + '\'' +
                ", starter_code_url='" + starter_code_url + '\'' +
                ", roster_identifier='" + roster_identifier + '\'' +
                ", student_repository_name='" + student_repository_name + '\'' +
                ", student_repository_url='" + student_repository_url + '\'' +
                ", submission_timestamp='" + submission_timestamp + '\'' +
                ", points_awarded=" + points_awarded +
                ", points_available=" + points_available +
                '}';
    }

    public StudentAndResult(String neptun_code, String student_name, String github_username, String assignment_name, String assignment_url, String starter_code_url, String roster_identifier, String student_repository_name, String student_repository_url, String submission_timestamp, Integer points_awarded, Integer points_available) {
        this.neptun_code = neptun_code;
        this.student_name = student_name;
        this.github_username = github_username;
        this.assignment_name = assignment_name;
        this.assignment_url = assignment_url;
        this.starter_code_url = starter_code_url;
        this.roster_identifier = roster_identifier;
        this.student_repository_name = student_repository_name;
        this.student_repository_url = student_repository_url;
        this.submission_timestamp = submission_timestamp;
        this.points_awarded = points_awarded;
        this.points_available = points_available;
    }

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

    public String getAssignment_name() {
        return assignment_name;
    }

    public void setAssignment_name(String assignment_name) {
        this.assignment_name = assignment_name;
    }

    public String getAssignment_url() {
        return assignment_url;
    }

    public void setAssignment_url(String assignment_url) {
        this.assignment_url = assignment_url;
    }

    public String getStarter_code_url() {
        return starter_code_url;
    }

    public void setStarter_code_url(String starter_code_url) {
        this.starter_code_url = starter_code_url;
    }

    public String getRoster_identifier() {
        return roster_identifier;
    }

    public void setRoster_identifier(String roster_identifier) {
        this.roster_identifier = roster_identifier;
    }

    public String getStudent_repository_name() {
        return student_repository_name;
    }

    public void setStudent_repository_name(String student_repository_name) {
        this.student_repository_name = student_repository_name;
    }

    public String getStudent_repository_url() {
        return student_repository_url;
    }

    public void setStudent_repository_url(String student_repository_url) {
        this.student_repository_url = student_repository_url;
    }

    public String getSubmission_timestamp() {
        return submission_timestamp;
    }

    public void setSubmission_timestamp(String submission_timestamp) {
        this.submission_timestamp = submission_timestamp;
    }

    public Integer getPoints_awarded() {
        return points_awarded;
    }

    public void setPoints_awarded(Integer points_awarded) {
        this.points_awarded = points_awarded;
    }

    public Integer getPoints_available() {
        return points_available;
    }

    public void setPoints_available(Integer points_available) {
        this.points_available = points_available;
    }
}
