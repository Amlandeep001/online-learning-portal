package com.example.learning.portal.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course
{
	private Integer id;
	private String name;
	private String instructor;
	private List<Rating> ratings = new ArrayList<>();

	public double getAverageRating()
	{
		if(ratings.isEmpty())
			return 0;
		return ratings.stream()
				.mapToInt(Rating::getStars)
				.average()
				.orElse(0);
	}
}
