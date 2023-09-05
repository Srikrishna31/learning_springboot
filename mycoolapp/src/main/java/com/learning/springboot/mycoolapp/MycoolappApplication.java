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
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        var studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        var myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student ...");
        myStudent.map(s -> {s.setFirstName("Scooby"); return s; });

        myStudent.ifPresentOrElse(
                s -> {
                    studentDAO.update(s);
                    System.out.println("Updated student: " + s);
                },
                () -> System.out.println("No student with id: " + studentId +
                " found"));
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        var students = studentDAO.findByLastName("Addepalli");

        students.forEach(System.out::println);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        var students = studentDAO.findAll();

        students.forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");
        var tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        var theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        System.out.println("Retrieving student with id: " + theId);
        var myStudent = studentDAO.findById(theId);

        myStudent.ifPresent(s -> {
            System.out.println("Found the student: " + s);
        });
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
