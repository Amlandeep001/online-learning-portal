package com.example.learning.portal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.example.learning.portal.config.FeignClientConfig;
import com.example.learning.portal.dto.Course;
import com.example.learning.portal.dto.Rating;

import java.util.List;

@FeignClient(name = "course-client",
        url = "${application.services.course.url}",
        configuration = FeignClientConfig.class)
public interface CourseClient {


    @GetMapping
    List<Course> courses();
    //create a proxy for the CourseClient
    //RestTemplate -> build the request
    // URL , GET , NO , List<COURSE>

    @GetMapping("/{id}")
    Course course(@PathVariable int id, @RequestHeader(name = "X-Request-Source") String sourceSystem);

    @PostMapping("/{id}/ratings")
    String submitRating(@PathVariable int id, @RequestBody Rating rating);

}