package TestDataAcessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import TestModel.*;

public class TestUpdateDataAcessLayer {
	Connection con;
	private String sqlString;
	private boolean exception = false;
	
	public void registerStudent(TestStudent student) {
		connection(createQueryForStudent("student", student));
	}
	
	public void registerCourse(TestCourse course) {
		connection(createQueryForCourse("Course", course));
	}
	
	public void registerStudentToCourse(TestStudent student, TestCourse course){
		connection(createQueryForStudentReadingCourse("Registered" , student, course));
	}
	
	public void deleteStudent(TestStudent student) {
		connection(createQueryForDeletingStudent("student", student));
	}
	
	public void deleteCourse(TestCourse course) {
		connection(createQueryForDeletingCourse("Course", course));
	}
	
	public void deleteStudentFromCourse(TestCourse course, TestStudent student) {
		connection(createQueryForDeletingStudentFromCourse("Registered", course, student));
	}
	
	public void registerStudentGrade(TestStudent student, TestCourse course, String grade) {
		connection(createQueryForGrading("Result", student, course, grade));
	}
	
	private String createQueryForStudent(String table, TestStudent student) {
		sqlString = "insert into " + table + " values(";
		sqlString += "'" + student.getSpnr() + "', ";
		sqlString += "'" + student.getName() + "', ";
		sqlString += "'" + student.getAdress() + "', ";
		sqlString += "'" + student.getTelnr() + "');";
		return sqlString;
	}
	
	private String createQueryForCourse(String table, TestCourse course) {
		sqlString = "insert into " + table + " values(";
		sqlString += "'" + course.getCcode() + "', ";
		sqlString += "'" + course.getCname() + "', ";
		sqlString += "'" + course.getCadress() + "', ";
		sqlString += "'" + course.getPoints() + "');";
		System.out.println(sqlString);
		return sqlString;
	}
	
	private String createQueryForStudentReadingCourse(String table, TestStudent student, TestCourse course) {
		sqlString = "insert into " + table + " values(";
		sqlString += "'" + student.getSpnr() + "', ";
		sqlString += "'" + course.getCcode() + "');";
		return sqlString;
	}
	
	private String createQueryForDeletingStudent(String table, TestStudent student) {
		sqlString = "delete from " + table + " where";
		sqlString += " spnr = '" + student.getSpnr() + "';";
		return sqlString;
	}
	
	private String createQueryForDeletingCourse(String table, TestCourse course) {
		sqlString = "delete from " + table + " where";
		sqlString += " ccode = '" + course.getCcode() + "';";
		return sqlString;
	}
	
	private String createQueryForDeletingStudentFromCourse(String table, TestCourse course, TestStudent student) {
		sqlString = "delete from " + table + " where";
		sqlString += " ccode = '" + course.getCcode(); 
		sqlString += "' and spnr = '" + student.getSpnr() + "';";
		return sqlString;
	}
	
	private String createQueryForGrading(String table, TestStudent student, TestCourse course, String grade) {
		sqlString = "insert into " + table;
		sqlString += " values ('" + student.getSpnr() + "', '" + course.getCcode() + "', '";
		sqlString += grade + "');";
		System.out.println(sqlString);
		return sqlString;
	}
	
	private void connection(String sqlStr) {
		try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            setException(false);
        }catch(Exception e) {
            System.out.println("Kan inte hitta database driver class: " + e);
            setException(true);
        }
        Connection con;
       
        try {
        	con = DriverManager.getConnection("jdbc:sqlserver://ZENBOOK\\MSSQLSERVER;", "user=Markus;", "password=1234Erdogan;");
        	Statement statement = con.createStatement ();
        	setException(false);
        	statement.executeUpdate(sqlStr);
        }catch (SQLException e) {
        	System.out.print("FEL DRIVERMANAGER TYP " + e);
        	setException(true);
        }
	}
	
	public void setException(boolean caughtException) {
		exception = caughtException;
	}
	
	public boolean getException() {
		return exception;
	}
}
