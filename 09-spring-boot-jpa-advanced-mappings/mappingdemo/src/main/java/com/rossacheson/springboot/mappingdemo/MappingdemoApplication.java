package com.rossacheson.springboot.mappingdemo;

import com.rossacheson.springboot.mappingdemo.dao.AppDAO;
import com.rossacheson.springboot.mappingdemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MappingdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAndStudents(appDAO);
			findCourseAndStudents(appDAO);
			findStudentAndCourses(appDAO);
		};
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int studentId = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(studentId);
		System.out.println("Student: " + student);
		System.out.println("Courses: " + student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int courseId = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(courseId);
		System.out.println("Loaded course: " + course);
		System.out.println("Students: " + course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("Pacman - How To Score One Million Points");

		Student student1 = new Student("John", "Doe", "john@test.com");
		Student student2 = new Student("Mary", "Knowing", "mary@test.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course: " + course);
		System.out.println("Associated students: " + course.getStudents());

		appDAO.saveCourse(course);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int courseId = 10;
		System.out.println("Deleting course " + courseId);
		appDAO.deleteCourseById(courseId);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int courseId = 10;
		Course course = appDAO.findCourseAndReviewsById(courseId);
		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How to Score One Million Points");
		course.addReview(new Review("Great course!"));
		course.addReview(new Review("Teacher is great"));
		course.addReview(new Review("Well done."));
		course.addReview(new Review("Too easy"));
		System.out.println("Saving the course " + course);
		System.out.println("Wth reviews " + course.getReviews());
		appDAO.saveCourse(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int courseId = 10;
		System.out.println("Deleting course id: " + courseId);
		appDAO.deleteCourseById(courseId);
	}

	private void updateCourse(AppDAO appDAO) {
		int courseId = 10;
		Course course = appDAO.findCourseById(courseId);
		course.setTitle("Air Guitar - The Ultimate Guide");
		appDAO.updateCourse(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int instructorId = 1;
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Found instructor: " + instructor);
		instructor.setLastName("Public");
		appDAO.updateInstructor(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int instructorId = 1;
		System.out.println("Finding instructor with ID: " + instructorId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(instructorId);
		System.out.println("Found instructor: " + instructor);
		System.out.println("With courses: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int instructorId = 1;
		List<Course> courses = appDAO.findCoursesByInstructorId(instructorId);
		System.out.println("Courses: " + courses);
	}

	private void findInstructorWithCoursesLazy(AppDAO appDAO) {
		int instructorId = 1;
		System.out.println("Finding instructor with ID: " + instructorId);
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Found instructor: " + instructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(instructorId);
		instructor.setCourses(courses);
		System.out.println("With courses: " + instructor.getCourses());
	}

	private void findInstructorWithCoursesEager(AppDAO appDAO) {
		int instructorId = 1;
		System.out.println("Finding instructor with ID: " + instructorId);
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Found instructor: " + instructor);
		System.out.println("With courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Susan", "Public", "susan@test.com");
		InstructorDetail instructorDetail =
				new InstructorDetail("SueChannel", "Gamer");
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.addCourse(course1);
		instructor.addCourse(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("With courses: " + instructor.getCourses());

		appDAO.save(instructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int instructorDetailId = 3;
		System.out.println("Deleting instructor detail with id " + instructorDetailId);
		appDAO.deleteInstructorDetailById(instructorDetailId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int instructorDetailId = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(instructorDetailId);
		System.out.println("Instructor Detail: " + instructorDetail);
		System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int instructorId = 1;
		System.out.println("Deleting instructor with id " + instructorId);
		appDAO.deleteInstructorById(instructorId);
	}

	private void findInstructor(AppDAO appDAO) {
		int instructorId = 2;
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Found instructor: " + instructor);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("John", "Doe", "john@doe.com");
		InstructorDetail instructorDetail =
				new InstructorDetail("CoolChannel", "Foosball");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
	}
}
