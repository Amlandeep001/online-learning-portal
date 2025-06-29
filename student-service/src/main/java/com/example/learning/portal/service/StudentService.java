package com.example.learning.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.learning.portal.client.CourseClient;
import com.example.learning.portal.dto.Course;
import com.example.learning.portal.dto.Rating;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService
{
	// private final CourseRestClientService courseClient;

	private final CourseClient courseClient;

	public Course searchCourse(int courseId, String sourceSystem)
	{
		return courseClient.course(courseId, sourceSystem);
	}

	public List<Course> getAllCourses()
	{
		return courseClient.courses();
	}

	public String submitRating(int courseId, Rating rating)
	{
		return courseClient.submitRating(courseId, rating);
	}
}