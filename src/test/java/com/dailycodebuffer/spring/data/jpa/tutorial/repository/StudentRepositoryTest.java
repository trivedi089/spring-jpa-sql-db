package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("satyachbs007+" + UUID.randomUUID() + "@gmail.com")
                .firstname("Satya")
                .lastName("Trivedi")
//                .guardianName("Dad")
//                .guardianMobile("xxx")
//                .guardianEmail("guardian@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void savesStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Dada of Body")
                .email("bodyday007@gmail.com")
                .mobile("85XXX")
                .build();

        Student student = Student.builder()
                .firstname("Bod")
                .lastName("Trivedi")
                .emailId("bod@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentsList = studentRepository.findAll();

        System.out.println("Student List = "+ studentsList);
    }

}