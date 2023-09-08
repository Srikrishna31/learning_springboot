package com.learning.springboot.mycoolapp.rest;

import com.learning.springboot.mycoolapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel", "abc@gmail.com"));
        theStudents.add(new Student("Mario", "Rossi", "def@gmail.com"));
        theStudents.add(new Student("Mary", "Smith", "ghi@gmail.com"));
    }
    @GetMapping("/students")
    List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    Student getStudent(@PathVariable int studentId) {
        if (studentId < 0 || studentId > theStudents.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    @ExceptionHandler
    ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
        var error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<StudentErrorResponse> handleException(Exception e) {
        var error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
