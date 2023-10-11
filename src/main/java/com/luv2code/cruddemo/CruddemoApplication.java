package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			 createStudent(studentDAO);
			 // createmultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			//  deleteAllStudents(studentDAO);
		};
	}

	// delete the all student present inside databases
	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : " + numRowsDeleted);
		System.out.println("Data delete Successfully...");
	}

	// delete student by using id
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Data delete Successfully...");
	}

	// Update student data to new data using id
	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "John"
		System.out.println("Updating student...");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student : " + myStudent);
	}

	// Display student by last name or any ather identity
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of student
		List<Student> theStudent = studentDAO.findByLastName("Karhade");

		// display list of students
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

	// read a list of student.../ display list of student
	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	// Read student by id
	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the studnet");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id : " + theId);

		// retrieve student based on the id: primaru key
		System.out.println("Retrieving student with Id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student : " + myStudent);
	}

	// Create multiple student / save multiple student data
	private void createmultipleStudent(StudentDAO studentDAO) {
		// create the student object

		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Natasha", "Rom", "natash@rom2.com");
		Student tempStudent2 = new Student("Mikhel", "Show", "mikhel@show1.com");
		Student tempStudent3 = new Student("Peter", "England", "peter@england1.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Data save successfully...");

	}

	// Create student / save student data
	private void createStudent(StudentDAO studentDAO) {
		// create the student object

		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display if of the saved student
		System.out.println("Save student. Generated id: " + tempStudent.getId());

	}
}
