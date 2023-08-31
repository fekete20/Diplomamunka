package com.uni.thesis.service;

import com.uni.thesis.dao.StudentDao;
import com.uni.thesis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CsvService {

    @Autowired
    StudentDao studentDao;

    public void uploadResultFromCsv(MultipartFile file) {
        String filename = file.getOriginalFilename();
        try {
            Files.write(Paths.get("csv/" + filename), file.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uploadStudentFromCsv(MultipartFile file) {
        String filename = file.getOriginalFilename();
        String filepath = "uploads/";

        try {
            Files.write(Paths.get("uploads/" + filename), file.getBytes());


            String line = "";
            String csvDelimiter = ";";

            File dir = new File(filepath + filename);
                try (BufferedReader br = new BufferedReader(new FileReader(filepath + filename))) {
                    br.readLine(); // header of the CSV
                    while ((line = br.readLine()) != null) {

                        line = line.replace("\"", "");
//                        System.out.println("sor:" + line);
                        String[] resultData = line.split(csvDelimiter);

 //                       System.out.println("Length of resultData: " + resultData.length);
 //                       for(String str : resultData) {
 //                           System.out.println(str);
 //                       }
                        Student student = new Student();
                        student.setNeptun_code(resultData[0]);
                        student.setGithub_username(resultData[1]);
                        student.setStudent_name(resultData[2]);

                        studentDao.save(student);


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
         dir.delete();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
