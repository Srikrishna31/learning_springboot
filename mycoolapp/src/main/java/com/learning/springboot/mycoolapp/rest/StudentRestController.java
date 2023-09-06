package com.learning.springboot.mycoolapp.rest;

import com.learning.springboot.mycoolapp.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornima", "Patel", "abc@gmail.com"));
        theStudents.add(new Student("Mario", "Rossi", "def@gmail.com"));
        theStudents.add(new Student("Mary", "Smith", "ghi@gmail.com"));

        return theStudents;
    }
}
