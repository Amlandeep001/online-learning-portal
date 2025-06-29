package com.example.learning.portal.exception;

public class CourseServiceException extends RuntimeException
{
	private static final long serialVersionUID = -5475917908319963355L;

	public CourseServiceException(String message)
	{
		super(message);
	}
}
