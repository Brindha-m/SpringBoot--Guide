//package com.binda.basicstudent.Config;
//
//import com.binda.basicstudent.Model.Student;
//import com.binda.basicstudent.Repository.StudentRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//@AutoConfiguration
//public class StudentConfig {
//    private List<Student> studentList;
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student smriti = new Student(
//                    "Smriti",
//                    LocalDate.parse("1997-07-18"),
//                    "smriti@gmail.com"
//            );
//
//            Student rohit = new Student(
//                    "Rohit",
//                    LocalDate.parse("1987-04-30"),
//                    "rohit@gmail.com"
//            );
//
//            studentList = new ArrayList<>();
//            studentList.add(smriti);
//            studentList.add(rohit);
//            repository.saveAll(studentList);
//
//        };
//    }
//}
