package com.uni.thesis.service;

import com.uni.thesis.dao.ResultDao;
import com.uni.thesis.entity.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.io.File;

@Service
public class ResultService {

    @Autowired
    private ResultDao resultDao;

    public Result addResult(Result result) {
        return resultDao.save(result);

    }

    public List<Result> getResults() {
        return (List<Result>) resultDao.findAll();

    }

    public void deleteResult(Integer id) {
        resultDao.deleteById(id);
    }

    public Result updateResult(Result result) {
        Integer resultID = result.getResultID();
        Result tempResult = resultDao.findById(resultID).get();

        tempResult.setAssignment_name(result.getAssignment_name());
        tempResult.setAssignment_url(result.getAssignment_url());
        tempResult.setStarter_code_url(result.getStarter_code_url());
        tempResult.setGithub_username(result.getGithub_username());
        tempResult.setRoster_identifier(result.getRoster_identifier());
        tempResult.setStudent_repository_name(result.getStudent_repository_name());
        tempResult.setStudent_repository_url(result.getStudent_repository_url());
        tempResult.setPoints_awarded(result.getPoints_awarded());
        tempResult.setPoints_available(result.getPoints_available());

        return resultDao.save(tempResult);
    }

    public void saveResultFromCsv() {
        System.out.println("Uploading from CSV started: " + LocalDateTime.now());

        String path = "csv";

        String line = "";
        String csvDelimiter = ","; // Change this to your CSV delimiter

        File dir = new File(path);
        File[] filenames = dir.listFiles(); // all files

        for (File name : filenames) {
            try (BufferedReader br = new BufferedReader(new FileReader(name))) {
                br.readLine();
                while ((line = br.readLine()) != null) {
                    line = line.replace("\"", "");
                    String[] resultData = line.split(csvDelimiter);
                    Result r = new Result();
                    r.setAssignment_name(resultData[0]);
                    r.setAssignment_url(resultData[1]);
                    r.setStarter_code_url(resultData[2]);
                    r.setGithub_username(resultData[3]);
                    r.setRoster_identifier(resultData[4]);
                    r.setStudent_repository_name(resultData[5]);
                    r.setStudent_repository_url(resultData[6]);
                    r.setSubmission_timestamp(resultData[7]);
                    r.setPoints_awarded(Integer.valueOf(resultData[8]));
                    r.setPoints_available(Integer.valueOf(resultData[9]));

                    resultDao.save(r);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            name.delete();
        }
        System.out.println("All data inserted to DB from CSV files: " + LocalDateTime.now());
    }

}
