package com.cg.springbootmicroservice1course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.springbootmicroservice1course.model.Course;
import com.cg.springbootmicroservice1course.repository.CourseRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    private final CourseRepository courseRepository;
    private final ImageUploadService imageUploadService;

    public CourseServiceImpl(CourseRepository courseRepository, ImageUploadService imageUploadService) {
        this.courseRepository = courseRepository;
        this.imageUploadService = imageUploadService;
    }

    public Course saveCourse(String title, String subtitle, Double price, MultipartFile thumbnail) throws IOException {
        String imageUrl = imageUploadService.upload(thumbnail);

        Course course = new Course();
        course.setTitle(title);
        course.setSubtitle(subtitle);
        course.setPrice(price);
        course.setCreateTime(LocalDateTime.now());
        course.setThumbnailUrl(imageUrl);

        return courseRepository.save(course);
    }

    
    @Override
    public void deleteCourse(Long courseId)
    {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> findAllCourses()
    {
        return courseRepository.findAll();
    }

}
