package com.cg.spring_boot_microservice_3_api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;


import com.cg.spring_boot_microservice_3_api_gateway.exception.ResourceNotFoundException;
import com.cg.spring_boot_microservice_3_api_gateway.request.CourseServiceRequest;

@RestController
@RequestMapping("gateway/course")//pre-path
public class CourseController
{
    @Autowired
    private CourseServiceRequest courseServiceRequest;

    
    @PostMapping("/add")
    public ResponseEntity<?> saveCourse(
            @RequestParam("title") String title,
            @RequestParam("subtitle") String subtitle,
            @RequestParam("price") Double price,
            @RequestParam("thumbnail") MultipartFile thumbnail) {

        return new ResponseEntity<>(
            courseServiceRequest.saveCourse(title, subtitle, price, thumbnail),
            HttpStatus.CREATED
        );
    }


    @DeleteMapping("{courseId}") // DELETE /gateway/course/{courseId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {
        try {
            courseServiceRequest.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResourceNotFoundException("Course with ID " + courseId + " not found.");
        }
    }
    
    

    @GetMapping//gateway/course
    public ResponseEntity<?> getAllCourses()
    {
        return ResponseEntity.ok(courseServiceRequest.getAllCourses());
    }
}
