package com.cg.springbootmicroservice1course.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cg.springbootmicroservice1course.model.Course;
import com.cg.springbootmicroservice1course.service.CourseService;

@RestController
@RequestMapping("api/course")//pre-path
public class CourseController
{
    @Autowired
    private CourseService courseService;
    

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveCourse(
            @RequestParam String title,
            @RequestParam String subtitle,
            @RequestParam Double price,
            @RequestParam("thumbnail") MultipartFile thumbnail
    ) {
        try {
            Course savedCourse = courseService.saveCourse(title, subtitle, price, thumbnail);
            return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload thumbnail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

    @DeleteMapping("{courseId}")//api/course/{courseId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId)
    {
        courseService.deleteCourse(courseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping //api/course
    public ResponseEntity<?> getAllCourses()
    {
        return ResponseEntity.ok(courseService.findAllCourses());
    }
}
