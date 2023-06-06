package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Review;
import com.vo.CourseReviewVO;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query("SELECT new com.vo.CourseReviewVO(c.title, c.description, r.text) FROM Review r JOIN course c")
	public List<CourseReviewVO> findCourseReview();

	@Query("SELECT new com.vo.CourseReviewVO(c.title, c.description, r.text) FROM Review r JOIN course c WHERE c.title LIKE :prefix")
	public List<CourseReviewVO> findCourseReviewByCourseTitleStartingWith(String prefix);

}
