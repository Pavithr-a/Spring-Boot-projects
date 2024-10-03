package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
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

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor=new Instructor("Dave","Hender","daveh@gmail.com");

		//create instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("https://davehander.com/youtube","Luv 2 code!!");


		//associate the obj
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1=new Course("Guitar-For beginners");
		Course tempCourse2=new Course("The Pinball masterclass");

				//add courses to instructor
				tempInstructor.add(tempCourse1);
				tempInstructor.add(tempCourse2);

				//NOTE:this will also save the courses becoz of cascadeType.PERSIST

		System.out.println("Saving Instructor:"+tempInstructor);
		System.out.println("The courses:"+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");



	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Find Instructor Detail:" +theId);

		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: "+tempInstructorDetail);

		System.out.println("The associated instructor: "+tempInstructorDetail.getInstructor());
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
