package com.cg.spring_boot_microservice_3_api_gateway.request;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
    value = "course-service",
    path = "/api/course",
    configuration = FeignConfiguration.class
)
public interface CourseServiceRequest {

	@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	Object saveCourse(
	    @RequestPart("title") String title,
	    @RequestPart("subtitle") String subtitle,
	    @RequestPart("price") Double price,
	    @RequestPart("thumbnail") MultipartFile thumbnail
	);


    @DeleteMapping("{courseId}")
    void deleteCourse(@PathVariable("courseId") Long courseId);

    @GetMapping
    List<Object> getAllCourses();
}
