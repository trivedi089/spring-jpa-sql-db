package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourseMaterials() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses = "+courses);
    }

    @Test
    public void findAllPagination(){

        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        Long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        System.out.println("Total elements = "+totalElements);
        System.out.println("Total pages = "+totalPages);
        System.out.println("Number of elements = "+courses.size());
    }

    @Test
    public void findAllSorting(){

        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc=  PageRequest.of(0,2, Sort.by("Credit").descending());

        Pageable sortByTitleAndCreditDesc =  PageRequest.of(0,2, Sort.by("title").descending()
                .and(Sort.by("Credit").descending()));

        List<Course> courses = courseRepository.findAll();
    }
}