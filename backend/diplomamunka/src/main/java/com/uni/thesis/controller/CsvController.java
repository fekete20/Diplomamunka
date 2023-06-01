package com.uni.thesis.controller;

import com.uni.thesis.service.CsvService;
import com.uni.thesis.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CsvController {

    @Autowired
    ResultService resultService;

    @Autowired
    CsvService csvService;

    @PostMapping("/uploadResultData")
    public void uploadResultFromCsvUpload(@RequestParam("file") MultipartFile file) {
        csvService.uploadResultFromCsv(file);
        resultService.saveResultFromCsv();

    }

    @PostMapping("/uploadStudentData")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        csvService.uploadStudentFromCsv(file);

    }
}
