package com.binda.basicstudent.Repository;

import com.binda.basicstudent.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
//
//    @Query("SELECT s FROM Student s WHERE s.email =?1")
//    Student findStudentByEmailNew(String email);

    Student save(Student student);

    Optional<Student> findByName(String name);
}
