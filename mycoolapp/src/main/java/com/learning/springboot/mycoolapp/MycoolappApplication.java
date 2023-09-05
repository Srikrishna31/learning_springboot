package com.learning.springboot.mycoolapp;

import com.learning.springboot.mycoolapp.dao.StudentDAO;
import com.learning.springboot.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.learning.springboot.mycoolapp",
                "com.learning.springboot.util"
        }
)
public class MycoolappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Krishna", "Addepalli", "coolkrishna31@gmail.com");
        Student tempStudent1 = new Student("Mary", "Public", "mary@gmail.com");
        Student tempStudent2 = new Student("Bonita", "Applebum", "bonita@gmail.com");

        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent);
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Krishna", "Addepalli", "coolkrishna31@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
