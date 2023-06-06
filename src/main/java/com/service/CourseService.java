package com.service;

import java.util.List;

import com.entity.Course;

public interface CourseService {

	public void save(Course course);

	public void deleteById(Integer courseId);

	public List<Course> findAll();

}
