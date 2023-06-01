package com.uni.thesis.controller;

import com.uni.thesis.entity.Result;
import com.uni.thesis.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping("/registerResult")
    public Result registerResult(@RequestBody Result result) {
        return resultService.addResult(result);
    }

    @GetMapping("/getResults")
    public List<Result> getResults() {
        return resultService.getResults();
    }

    @DeleteMapping("/deleteResult")
    public void deleteResult(@RequestParam Integer id) {
        resultService.deleteResult(id);
    }

    @PutMapping("/updateResult")
    public Result updateResult(@RequestBody Result result) {
        return resultService.updateResult(result);
    }


    @GetMapping("/resultsToDB")
    public void resultsToDB() {
        resultService.saveResultFromCsv();
    }

}
