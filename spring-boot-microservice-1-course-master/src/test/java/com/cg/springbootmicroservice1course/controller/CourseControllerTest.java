package com.cg.springbootmicroservice1course.controller;

import com.cg.springbootmicroservice1course.model.Course;
import com.cg.springbootmicroservice1course.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllCourses() throws Exception {
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

        when(courseService.findAllCourses()).thenReturn(Arrays.asList(course1, course2));

        mockMvc.perform(get("/api/course"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void testSaveCourse() throws Exception {
        MockMultipartFile file = new MockMultipartFile("thumbnail", "test.jpg", "image/jpeg", "dummy-image-content".getBytes());

        Course savedCourse = new Course();
        savedCourse.setId(1L);
        savedCourse.setTitle("Java");
        savedCourse.setSubtitle("Java Basics");
        savedCourse.setPrice(199.0);
        savedCourse.setCreateTime(LocalDateTime.now());
        savedCourse.setThumbnailUrl("http://dummy.url/image.jpg");

        when(courseService.saveCourse(eq("Java"), eq("Java Basics"), eq(199.0), any())).thenReturn(savedCourse);

        mockMvc.perform(multipart("/api/course/add")
                        .file(file)
                        .param("title", "Java")
                        .param("subtitle", "Java Basics")
                        .param("price", "199.0"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Java"))
                .andExpect(jsonPath("$.thumbnailUrl").value("http://dummy.url/image.jpg"));
    }

    @Test
    void testDeleteCourse() throws Exception {
        doNothing().when(courseService).deleteCourse(1L);

        mockMvc.perform(delete("/api/course/1"))
                .andExpect(status().isOk());
    }
}















//package com.cg.springbootmicroservice1course.controller;
//
//import com.cg.springbootmicroservice1course.model.Course;
//import com.cg.springbootmicroservice1course.service.CourseService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//
//
//
//@AutoConfigureMockMvc(addFilters = false)
//@WebMvcTest(CourseController.class)
//public class CourseControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CourseService courseService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void testGetAllCourses() throws Exception {
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
//        when(courseService.findAllCourses()).thenReturn(Arrays.asList(course1, course2));
//
//        mockMvc.perform(get("/api/course"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(2)));
//    }
//
//    @Test
//    void testSaveCourse() throws Exception {
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
//        when(courseService.saveCourse(Mockito.any(Course.class))).thenReturn(savedCourse);
//
//
//        mockMvc.perform(post("/api/course")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(course)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.title", is("Java")))
//                .andExpect(jsonPath("$.subtitle", is("Java Basics")));
//    }
//
//    @Test
//    void testDeleteCourse() throws Exception {
//        doNothing().when(courseService).deleteCourse(1L);
//
//        mockMvc.perform(delete("/api/course/1"))
//                .andExpect(status().isOk());
//    }
//}


