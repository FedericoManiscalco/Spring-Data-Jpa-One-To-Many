package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ReviewService;
import com.vo.CourseReviewVO;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
public class CourseReviewController {

	@Autowired
	private ReviewService rs;

	@GetMapping("api/v1/coursereviews")
	public List<CourseReviewVO> getCoursesReviews() {
		return rs.findCourseReview();
	}

}
