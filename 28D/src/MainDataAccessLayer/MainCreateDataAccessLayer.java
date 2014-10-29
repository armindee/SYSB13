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
		
		
	}
	
	public void registerCourse(MainCourse Course){
		
	}
	
	public void registerStudentForCourse(MainStudent Student){
		
	}
	
	public void deleteStudent(MainStudent Student){
		
	}
	public void deleteCourse(MainCourse Course){
		
	}
	
	public void deleteStudentReadingCourse(MainCourse Course, MainStudent Student){
		
	}

	public void registerStudentGrade(MainStudent Student, MainCourse Course){
		
	}
}
