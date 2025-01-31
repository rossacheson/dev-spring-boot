package com.rossacheson.springboot.mappingdemo;

import com.rossacheson.springboot.mappingdemo.dao.AppDAO;
import com.rossacheson.springboot.mappingdemo.entity.Instructor;
import com.rossacheson.springboot.mappingdemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
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
