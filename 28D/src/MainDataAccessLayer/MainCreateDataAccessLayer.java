package MainDataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import MainModel.*;

public class MainCreateDataAccessLayer {
	Connection connect;
	private String sqlString;
	private boolean exception = false;
	
	public void registerStudent(MainStudent Student){
		connection(createQueryForStudent("student", student));
	}
	
	public void registerCourse(MainCourse Course){
		connection(createQueryForCourse("Course", course));
	}
	
	public void registerStudentForCourse(MainStudent Student){
		connection(createQueryForStudentReadingCourse("Registered" , student, course));
	}
	
	public void deleteStudent(MainStudent Student){
		connection(createQueryForDeletingStudent("student", student));
	}
	public void deleteCourse(MainCourse Course){
		connection(createQueryForDeletingCourse("Course", course));
	}
	
	public void deleteStudentReadingCourse(MainCourse Course, MainStudent Student){
		connection(createQueryForDeletingStudentFromCourse("Registered", course, student));
	}

	public void registerStudentGrade(MainStudent Student, MainCourse Course){
		connection(createQueryForGrading("Result", student, course, grade));
	}

	
}
