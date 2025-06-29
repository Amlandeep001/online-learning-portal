package com.example.learning.portal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.portal.dto.Course;
import com.example.learning.portal.dto.Rating;
import com.example.learning.portal.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController
{
	private final CourseService courseService;

	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses()
	{
		return ResponseEntity.ok(courseService.getAllCourses());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCourse(@PathVariable int id,
			@RequestHeader(name = "X-Request-Source") String sourceSystem)
	{
		// sourceSystem -> udemy , coursera , unacademy
		// udemy -> 2
		// coursera-> 1
		// unacademy -> all

		return switch(sourceSystem.toLowerCase())
		{
			case "udemy" -> (id == 2) ? fetchCourse(id)
					: ResponseEntity.badRequest()
							.body("Udemy does not have a course with ID " + id + ". Please provide a valid ID.");

			case "coursera" -> (id == 1) ? fetchCourse(id)
					: ResponseEntity.badRequest()
							.body("coursera does not have a course with ID " + id + ". Please provide a valid ID.");

			case "unacademy" -> fetchCourse(id);

			default -> ResponseEntity.internalServerError()
					.body("Unknown source system: " + sourceSystem);
		};
	}

	private ResponseEntity<Course> fetchCourse(int id)
	{
		return ResponseEntity.ok(courseService.getCourseById(id));
	}

	@PostMapping("/{id}/ratings")
	public ResponseEntity<String> addRating(@PathVariable int id, @RequestBody Rating rating)
	{
		boolean added = courseService.addRating(id, rating);
		if(added)
		{
			return ResponseEntity.ok("Rating submitted successfully!");
		}
		else
		{
			return ResponseEntity.badRequest().body("Course not found.");
		}
	}

}