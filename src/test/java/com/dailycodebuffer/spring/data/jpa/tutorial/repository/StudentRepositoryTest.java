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
                .firstName("Satya")
                .lastName("Trivedi")
//                .guardianName("Dad")
//                .guardianMobile("xxx")
//                .guardianEmail("guardian@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void savesStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Dada of Body")
                .email("bodyday007+" + UUID.randomUUID() + "@gmail.com")
                .mobile("85XXX")
                .build();

        Student student = Student.builder()
                .firstName("Bod")
                .lastName("Trivedi")
                .emailId("bod+" + UUID.randomUUID() + "@gmail.com")  // unique email to avoid duplicate error
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentsList = studentRepository.findAll();

        System.out.println("Student List = "+ studentsList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("Satya");
        System.out.println("Students = "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstName("Sa");
        System.out.println("Students Containing = "+ students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students = studentRepository.findByGuardianName("Dada of Body");
        System.out.println("Students = "+ students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("satyachbs007+" + UUID.randomUUID() + "@gmail.com");
        System.out.println("Student = "+ student);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("satyachbs007@gmail.com");
        System.out.println("Student = "+ student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNative("satyachbs007@gmail.com");
        System.out.println("Student = "+ student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){

        studentRepository.updateStudentNameByEmailId("satya trivedi","satyachbs007@gmail.com");
    }
}