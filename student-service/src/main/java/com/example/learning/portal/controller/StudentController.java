package com.example.learning.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.portal.dto.Course;
import com.example.learning.portal.dto.Rating;
import com.example.learning.portal.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController
{
	private final StudentService studentService;

	@GetMapping("/search/{courseId}")
	public Course search(@PathVariable int courseId, @RequestParam String sourceSystem)
	{
		// hardcode // pathVariable // requestParam
		return studentService.searchCourse(courseId, sourceSystem);
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses()
	{
		return studentService.getAllCourses();
	}

	@PostMapping("/courses/{courseId}/ratings")
	public String submitRating(@PathVariable int courseId, Rating rating)
	{
		return studentService.submitRating(courseId, rating);
	}
}