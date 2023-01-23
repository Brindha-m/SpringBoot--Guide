package com.binda.basicstudent.Service;

import com.binda.basicstudent.Model.Student;
import com.binda.basicstudent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // For Get Method
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student saveStudent) {
        return studentRepository.save(saveStudent);

    }

    //Delete Method. Update & addStudent method are directly written in controller itself

    public void deleteStudent(String studentId) {
        boolean exists = studentRepository.existsById((studentId));
        if (!exists) {
            throw new IllegalStateException("Student with ID " + studentId + "doesn't exist");
        }
        studentRepository.deleteById((studentId));
    }


}


