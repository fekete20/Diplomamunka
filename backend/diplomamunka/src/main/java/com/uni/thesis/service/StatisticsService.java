package com.uni.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Object> getDownloadedTasksCountAndPoints() {
        String query = "select student.neptun_code, count(result.assignment_name), sum(result.points_awarded) from result inner join student on result.github_username = student.github_username group by student.neptun_code";
        var resultSet = jdbcTemplate.queryForList(query);
        List<Object> resultToFrontend = new ArrayList<>();
        resultSet.forEach((key) -> {
            resultToFrontend.add(key.values());
        });

        return resultToFrontend;
    }

    public List<Object> getFullPointData() {
        String query = "select s.neptun_code, count(r.assignment_name) from result r inner join student s on r.github_username = s.github_username where r.points_awarded = r.points_available group by s.neptun_code";
        var resultSet = jdbcTemplate.queryForList(query);
        List<Object> resultToFrontend = new ArrayList<>();
        resultSet.forEach((key) -> {
            resultToFrontend.add(key.values());
        });

        return resultToFrontend;
    }

    public List<Object> getPercentageDownloaded() {
        String query = "select student.neptun_code, (count(result.assignment_name)/(select count(distinct assignment_name) from result))*100 from result inner join student on result.github_username = student.github_username group by student.neptun_code";
        var resultSet = jdbcTemplate.queryForList(query);
        List<Object> resultToFrontend = new ArrayList<>();
        resultSet.forEach((key) -> {
            resultToFrontend.add(key.values());
        });

        return resultToFrontend;
    }

    public List<Object> getCountDownloaded() {
        String query = "select github_username, count(assignment_name) from result group by github_username";
        var resultSet = jdbcTemplate.queryForList(query);
        List<Object> resultToFrontend = new ArrayList<>();
        resultSet.forEach((key) -> {
            resultToFrontend.add(key.values());
        });

        return resultToFrontend;
    }
}
