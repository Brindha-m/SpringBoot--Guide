package com.binda.basicstudent.Controller;

import com.binda.basicstudent.Model.Student;
import com.binda.basicstudent.Repository.StudentRepository;
import com.binda.basicstudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/all")
    public List<Student> getStudent() {
        return studentService.getStudent();
    }


    @PostMapping("/add")
    public void newStudent(@Valid @RequestBody Student student) {
        studentService.addNewStudent(student);
    }

//    Post other ways

    @PostMapping("/addStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student newStudent = studentRepository.save(new Student(student.getName(), student.getDob(), student.getEmail()));
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new IllegalStateException("Email is Taken.");
        }

    }

    @DeleteMapping("delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.deleteStudent(String.valueOf(studentId));
        //return "redirect:/home/";
    }

    /**
     * Update.
     *
     * @param studentId the unique id of a student
     * @throws Exception the exception
     */

    @PutMapping("update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") String studentId,
                                                 @Valid @RequestBody Student student) {
        Student existStudent = studentRepository
                .findById((studentId))
                .orElseThrow(() -> new ResourceNotFoundException("Student with ID " + studentId + "doesn't exist"));

        existStudent.setName(student.getName());
        existStudent.setEmail(student.getEmail());
        existStudent.setDob(student.getDob());
        final Student updatedStudent = studentRepository.save(existStudent);
        return ResponseEntity.ok(updatedStudent);

    }

}

