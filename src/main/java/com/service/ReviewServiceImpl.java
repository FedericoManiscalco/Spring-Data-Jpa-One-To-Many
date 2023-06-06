package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Review;
import com.repository.ReviewRepository;
import com.vo.CourseReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository rr;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void save(Review review) {
		try {
			rr.save(review);
			log.info("Save riuscito.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Save fallito.");
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(Integer reviewId) {
		if (rr.existsById(reviewId)) {
			try {
				rr.deleteById(reviewId);
				log.info("Recensione eliminata.");
			} catch (IllegalArgumentException iae) {
				log.info("Recensione non eliminata.");
				iae.printStackTrace();
			}
		} else {
			log.info("Recensione non trovata.");
		}
	}

	@Override
	public List<Review> findAll() {
		List<Review> reviews = rr.findAll();
		if (reviews != null && !reviews.isEmpty()) {
			log.info("Recensioni trovate.");
			reviews.forEach(System.out::println);
		} else {
			log.info("Recensioni non trovate.");
		}
		return reviews;
	}

	@Override
	public List<CourseReviewVO> findCourseReview() {
		List<CourseReviewVO> coursesReviews = rr.findCourseReview();
		if (coursesReviews != null && !coursesReviews.isEmpty()) {
			log.info("CourseReviewVO trovate.");
			coursesReviews.forEach(System.out::println);
		} else {
			log.info("CourseReviewVO non trovate.");
		}
		return coursesReviews;
	}

	@Override
	public List<CourseReviewVO> findCourseReviewByCourseTitleStartingWith(String prefix) {
		List<CourseReviewVO> coursesReviews = rr.findCourseReviewByCourseTitleStartingWith(prefix + "%");
		if (coursesReviews != null && !coursesReviews.isEmpty()) {
			log.info("CourseReviewVO trovate.");
			coursesReviews.forEach(System.out::println);
		} else {
			log.info("CourseReviewVO non trovate.");
		}
		return coursesReviews;
	}

}
