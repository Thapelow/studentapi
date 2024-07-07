package com.goosenvi.studentapi.controller;

import com.goosenvi.studentapi.model.StudentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("student")
    public void logStudent(@RequestBody StudentInfo studentInfo) {
        log.info("Student info: {}", studentInfo.getStudentInformation());
    }

    @PutMapping("student")
    public void updateStudent(@RequestBody StudentInfo studentInfo) {
        log.info("Student info updated: {}", studentInfo.getStudentInformation());
    }

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        log.info("Student info deleted: {}", id);
    }
}
