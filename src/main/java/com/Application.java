package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Course;
import com.entity.Review;
import com.service.CourseService;
import com.service.ReviewService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CourseService cs;

	@Autowired
	private ReviewService rs;

	@Resource
	private Course c1;

	@Resource
	private Course c2;

	@Resource
	private Course c3;

	@Resource
	private Review r1;

	@Resource
	private Review r3;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		r1.setCourse(c1);
		r1.setText("Recensione 1");

		r3.setCourse(c3);
		r3.setText("Recensione 3");

		c1.setTitle("Java 1");
		c1.setDescription("Descrizione Corso 1");

		c2.setTitle("Angular 2");
		c2.setDescription("Descrizione Corso 2");

		c3.setTitle("Javascript 3");
		c3.setDescription("Descrizione Corso 3");

		cs.save(c1);
		cs.save(c2);
		cs.save(c3);

		rs.save(r1);
		rs.save(r3);

		rs.findCourseReview();

		rs.findCourseReviewByCourseTitleStartingWith("Java");

		rs.findAll();

	}

}
