package com.cg.springbootmicroservice1course.service;

import com.cg.springbootmicroservice1course.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseService {
    Course saveCourse(String title, String subtitle, Double price, MultipartFile thumbnail) throws IOException;

    void deleteCourse(Long courseId);

    List<Course> findAllCourses();
}
