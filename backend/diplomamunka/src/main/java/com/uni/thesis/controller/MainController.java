package com.uni.thesis.controller;

import com.uni.thesis.entity.StudentAndResult;
import com.uni.thesis.service.LinkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    LinkingService linkingService;

    @GetMapping("/getCommonTable")
    public List<StudentAndResult> getCommonTable() {
        return linkingService.linker();
    }

}
