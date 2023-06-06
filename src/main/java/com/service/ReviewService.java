package com.service;

import java.util.List;

import com.entity.Review;
import com.vo.CourseReviewVO;

public interface ReviewService {

	public void save(Review review);

	public void deleteById(Integer reviewId);

	public List<Review> findAll();

	public List<CourseReviewVO> findCourseReview();

	public List<CourseReviewVO> findCourseReviewByCourseTitleStartingWith(String prefix);

}
