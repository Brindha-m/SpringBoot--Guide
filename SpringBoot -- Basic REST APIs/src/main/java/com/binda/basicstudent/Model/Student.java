package com.binda.basicstudent.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Data // It is the combination of getter,setters. So, not needed to write getters & setters separately
@AllArgsConstructor // Inorder to create constructors
@NoArgsConstructor
@ToString
@Document(collection = "Student")
public class Student implements Serializable {
    @Id
    private String id;

    private String name;
    private LocalDate dob;
    @Transient
    private Integer age;
    @Indexed(unique = true)
    private String email;


    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    //For passing Hard-Coded data from the StudentConfig file.

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
}
