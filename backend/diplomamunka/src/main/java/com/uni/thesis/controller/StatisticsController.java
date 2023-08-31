package com.uni.thesis.controller;

import com.uni.thesis.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;


    @GetMapping("/getDownloadedTasksCountAndPoints")
    public List<Object> getDownloadedTasksCountAndPoints() {
        return statisticsService.getDownloadedTasksCountAndPoints();
    }

    @GetMapping("/getFullPointData")
    public List<Object> getFullPointData() {
        return statisticsService.getFullPointData();
    }

    @GetMapping("/getPercentageDownloaded")
    public List<Object> getPercentageDownloaded() {
        return statisticsService.getPercentageDownloaded();
    }

    @GetMapping("/getCountDownloaded")
    public List<Object> getCountDownloaded() {
        return  statisticsService.getCountDownloaded();
    }
}
