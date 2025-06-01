package com.cg.springbootmicroservice1course.service;

import com.cg.springbootmicroservice1course.model.Course;
import com.cg.springbootmicroservice1course.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private ImageUploadService imageUploadService;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllCourses() {
        Course course1 = new Course();
        course1.setId(1L);
        course1.setTitle("Java");
        course1.setSubtitle("Java Basics");
        course1.setPrice(199.0);
        course1.setCreateTime(LocalDateTime.now());

        Course course2 = new Course();
        course2.setId(2L);
        course2.setTitle("Python");
        course2.setSubtitle("Python Basics");
        course2.setPrice(149.0);
        course2.setCreateTime(LocalDateTime.now());

        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        List<Course> courses = courseService.findAllCourses();
        assertEquals(2, courses.size());
    }

    @Test
    void testSaveCourse() throws IOException {
        MockMultipartFile mockFile = new MockMultipartFile("file", "test.jpg", "image/jpeg", "dummy-image-content".getBytes());

        Course savedCourse = new Course();
        savedCourse.setId(1L);
        savedCourse.setTitle("Java");
        savedCourse.setSubtitle("Java Basics");
        savedCourse.setPrice(199.0);
        savedCourse.setCreateTime(LocalDateTime.now());
        savedCourse.setThumbnailUrl("http://dummy.url/image.jpg");

        when(imageUploadService.upload(mockFile)).thenReturn("http://dummy.url/image.jpg");
        when(courseRepository.save(any(Course.class))).thenReturn(savedCourse);

        Course result = courseService.saveCourse("Java", "Java Basics", 199.0, mockFile);

        assertNotNull(result.getId());
        assertEquals("Java", result.getTitle());
        assertEquals("http://dummy.url/image.jpg", result.getThumbnailUrl());
    }

    @Test
    void testDeleteCourse() {
        Long courseId = 1L;
        doNothing().when(courseRepository).deleteById(courseId);

        courseService.deleteCourse(courseId);
        verify(courseRepository, times(1)).deleteById(courseId);
    }
}

















//package com.cg.springbootmicroservice1course.service;
//
//import com.cg.springbootmicroservice1course.model.Course;
//import com.cg.springbootmicroservice1course.repository.CourseRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class CourseServiceImplTest {
//
//    @Mock
//    private CourseRepository courseRepository;
//
//    @InjectMocks
//    private CourseServiceImpl courseService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testFindAllCourses() {
//        Course course1 = new Course();
//        course1.setId(1L);
//        course1.setTitle("Java");
//        course1.setSubtitle("Java Basics");
//        course1.setPrice(199.0);
//        course1.setCreateTime(LocalDateTime.now());
//
//        Course course2 = new Course();
//        course2.setId(2L);
//        course2.setTitle("Python");
//        course2.setSubtitle("Python Basics");
//        course2.setPrice(149.0);
//        course2.setCreateTime(LocalDateTime.now());
//
//        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));
//
//        List<Course> courses = courseService.findAllCourses();
//        assertEquals(2, courses.size());
//    }
//
//    @Test
//    void testSaveCourse() {
//        Course course = new Course();
//        course.setTitle("Java");
//        course.setSubtitle("Java Basics");
//        course.setPrice(199.0);
//
//        Course savedCourse = new Course();
//        savedCourse.setId(1L);
//        savedCourse.setTitle("Java");
//        savedCourse.setSubtitle("Java Basics");
//        savedCourse.setPrice(199.0);
//        savedCourse.setCreateTime(LocalDateTime.now());
//
//        when(courseRepository.save(any(Course.class))).thenReturn(savedCourse);
//
//        Course result = courseService.saveCourse(course);
//        assertNotNull(result.getId());
//        assertEquals("Java", result.getTitle());
//    }
//
//    @Test
//    void testDeleteCourse() {
//        Long courseId = 1L;
//        doNothing().when(courseRepository).deleteById(courseId);
//
//        courseService.deleteCourse(courseId);
//        verify(courseRepository, times(1)).deleteById(courseId);
//    }
//}
