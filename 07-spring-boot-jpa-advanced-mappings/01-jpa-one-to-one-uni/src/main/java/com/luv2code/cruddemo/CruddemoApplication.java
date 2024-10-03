package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=2;
		System.out.println("Delete instructor id: "+theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=3;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("temp constructor :"+tempInstructor);
		System.out.println("The associated instructorDetail only :"+tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
		//create instructor
		Instructor tempInstructor=new Instructor("Pavi","Senthil","pavi@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("https://pavi.com/youtube","Luv 2 code!!");


		//associate the obj
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save
		System.out.println("Saving constructor: "+tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!!");
	}

}
