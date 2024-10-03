package com.luv2code.employeedemo;

import com.luv2code.employeedemo.dao.EmployeeDao;
import com.luv2code.employeedemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EmployeedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDao employeeDao){
		return runner -> {
			createEmployee(employeeDao); //1
			//createMultipleEmployees(employeeDao); //2
			//readEmployees(employeeDao); //3
			//queryForEmployees(employeeDao); //4
			//queryForEmployeesByLastName(employeeDao);//5
			//updateEmployee(employeeDao);//6
			//deleteEmployee(employeeDao);//7
			//deleteAllEmployees(employeeDao);//8

		};
	}



	private void createEmployee(EmployeeDao employeeDao) {
		//creating new obj
		System.out.println("Creating new employee object...");
		Employee tempEmployee=new Employee("John","Wick","jw@dee.com",34900);

		//saving obj
		System.out.println("Saving employee...");
		employeeDao.save(tempEmployee);
	}

	private void createMultipleEmployees(EmployeeDao employeeDao) {
		//creating multiple new obj
		System.out.println("Creating multiple new objs...");
		Employee tempEmployee1=new Employee("Ram","Charan","rc@dee.com",43500.50);
		Employee tempEmployee2=new Employee("Sri","Shan","sh@dee.com",60000);
		Employee tempEmployee3=new Employee("Anan","Sharma","Ansh@dee.com",54000);

		//saving objs
		System.out.println("Saving all objects...");
		employeeDao.save(tempEmployee1);
		employeeDao.save(tempEmployee2);
		employeeDao.save(tempEmployee3);

	}

	private void readEmployees(EmployeeDao employeeDao) {
		//creating new obj
		System.out.println("Creating a new object....");
		Employee tempEmployee=new Employee("Pavi","Senthil","ps@dee.com",200000);

		//saving object
		System.out.println("Saving the employee....");
		employeeDao.save(tempEmployee);

		//display obj
		System.out.println("Display new employee: "+tempEmployee.getId());

		//reading obj
		System.out.println("reading the employee...");
		System.out.println("Retrieving employee with id: "+tempEmployee.getId());
		Employee myEmployee=employeeDao.findByid(tempEmployee.getId());

		System.out.println("Found employee : "+myEmployee);
	}

	private void queryForEmployees(EmployeeDao employeeDao) {
		//get a list of employees
		List<Employee> theEmployees=employeeDao.findAll();

		//display the employees
		for(Employee tempEmployees:theEmployees){
			System.out.println(tempEmployees);
		}

	}

	private void queryForEmployeesByLastName(EmployeeDao employeeDao) {
		List<Employee> theEmployees=employeeDao.findByLastname("Senthil");

		for (Employee tempEmployees:theEmployees){
			System.out.println(tempEmployees);
		}
	}

	private void updateEmployee(EmployeeDao employeeDao) {
		int studentId=4;
		System.out.println("Find employee by id..."+studentId);
		Employee myEmployee=employeeDao.findByid(studentId);

		System.out.println("Updating name....");
		myEmployee.setLastName("Karthik");

		employeeDao.update(myEmployee);

		System.out.println("Updated employee... : "+myEmployee);

	}

	private void deleteEmployee(EmployeeDao employeeDao) {
		int studentId=3;
		System.out.println("Employee needed to delete.."+studentId);

		employeeDao.delete(studentId);

	}

	private void deleteAllEmployees(EmployeeDao employeeDao) {
		System.out.println("Deleting employees..");
		int numRowsdeleted=employeeDao.deleteAll();

		System.out.println("Deleting row count..."+numRowsdeleted);

	}
}
