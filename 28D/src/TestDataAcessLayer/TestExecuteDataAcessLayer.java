package TestDataAcessLayer;

import java.sql.*;
import java.util.ArrayList;

import TestModel.*;

public class TestExecuteDataAcessLayer {
	private ResultSet rset;
	private TestCourse course;
	private TestStudent student;
	private String Cname;
	private String Cadress;
	private int Cpoints;
	private String Sname;
	private String Sadress;
	private String Stel;
	private String sqlString;
	private String grade;
	private boolean exception;
	
	public TestExecuteDataAcessLayer() {
		exception = false;
	}
	
	public TestStudent getStudent(String spnr) {
		
		sqlString = "select * from student where spnr='"+ spnr + "'";
		
		ResultSet resultSet = connection(sqlString);
		
		try {
			resultSet.next();
			setException(false);
			Sname = resultSet.getString(2);
			Sadress = resultSet.getString(3);
			Stel = resultSet.getString(4);

		}catch (SQLException e) {
			e.printStackTrace();
			setException(true);
		}
		
		student = new TestStudent(spnr, Sname, Sadress, Stel);
		return student;
	}

	public TestCourse getCourse(String ccode) {
		sqlString = "select * from course where ccode='"+ccode+"'";
		ResultSet resultSet = connection(sqlString);
		
		try {
			resultSet.next();
			setException(false);
			Cname = resultSet.getString(2);
			Cadress = resultSet.getString(3);
			Cpoints = resultSet.getInt(4);
			
		}catch (SQLException e) {
			e.printStackTrace();
			setException(true);
		}
		
		course = new TestCourse(ccode, Cname, Cadress, Cpoints);
		return course;
	}
	
	public String getGrade(String ccode, String spnr) {
		sqlString = "select grade from result where ccode='" + ccode + "' and spnr = '" + spnr +"'";
		ResultSet resultSet = connection(sqlString);
		
		try {
			resultSet.next();
			setException(false);
			grade = resultSet.getString(1);
			
		}catch (SQLException e) {
			e.printStackTrace();
			setException(true);
		}
		return grade;
	}
	
	public ArrayList<TestStudent> getGradeList(String ccode) throws SQLException {
		ArrayList<TestStudent> gradeList = new ArrayList<TestStudent>();
		
		sqlString = "select s.sname, s.spnr, r.ccode, r.grade "
				+ "from student s join result r on s.spnr = r.spnr where ccode = '" + ccode + "'";
		ResultSet resultSet = connection(sqlString);
		
		while(resultSet.next()) {
			student = new TestStudent(resultSet.getString("sname"), resultSet.getString("spnr"), 
					resultSet.getString("ccode"), resultSet.getString("grade"));
			gradeList.add(student);
		}
		
		return gradeList;
	}
	
	public ArrayList<TestStudent> getRegisterdList(String ccode) throws SQLException {
		ArrayList<TestStudent> list = new ArrayList<TestStudent>();
		
		sqlString = "select s.sname, s.spnr, s.sadress, s.stel "
				+ "from student s join Registered r on s.spnr = r.spnr where ccode = '" + ccode + "'";
		ResultSet resultSet = connection(sqlString);
		
		while(resultSet.next()) {
			student = new TestStudent(resultSet.getString("sname"), resultSet.getString("spnr"), 
					resultSet.getString("sadress"), resultSet.getString("stel"));
			list.add(student);
		}
		return list;
	}
	
	public ArrayList<TestCourse> getStudentRegisterdList(String spnr) throws SQLException {
		ArrayList<TestCourse> list = new ArrayList<TestCourse>();
		
		sqlString = "select c.cname, c.ccode, c.cadress, c.points "
				+ "from Course c join Registered r on c.ccode = r.ccode where r.spnr = '" + spnr + "'";
		ResultSet resultSet = connection(sqlString);
		
		while(resultSet.next()) {
			course = new TestCourse(resultSet.getString("cname"), resultSet.getString("ccode"), 
					resultSet.getString("cadress"), resultSet.getInt("points"));
			list.add(course);
		}
		return list;
	}
	
	public ArrayList<TestStudent> getStudentsGrades(String spnr) throws SQLException {
		ArrayList<TestStudent> list = new ArrayList<TestStudent>();
		
		sqlString = "select s.sname, s.spnr, r.ccode, r.grade "
				+ "from student s join result r on s.spnr = r.spnr where s.spnr = '" + spnr + "'";
		ResultSet resultSet = connection(sqlString);
		
		while(resultSet.next()) {
			student = new TestStudent(resultSet.getString("sname"), resultSet.getString("spnr"), 
					resultSet.getString("ccode"), resultSet.getString("grade"));
			list.add(student);
		}
		return list;
	}
	
	public ArrayList<TestStudent> getAllStudents() throws SQLException {
		ArrayList<TestStudent> list = new ArrayList<TestStudent>();
		
		sqlString = "select* from student";
		ResultSet resultSet = connection(sqlString);
		
		while(resultSet.next()) {
			student = new TestStudent(resultSet.getString("spnr"), resultSet.getString("sname"), 
					resultSet.getString("sadress"), resultSet.getString("stel"));
			list.add(student);
		}
		return list;
	}
	
	public ArrayList<TestCourse> getAllCourses() throws SQLException {
		ArrayList<TestCourse> list = new ArrayList<TestCourse>();
		
		sqlString = "select* from course";
		ResultSet resultSet = connection(sqlString);
		
		while(resultSet.next()) {
			course = new TestCourse(resultSet.getString("ccode"), resultSet.getString("cname"), 
					resultSet.getString("cadress"), resultSet.getInt("points"));
			list.add(course);
		}
		return list;
	}
	
	private ResultSet connection(String sqlStr) {
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
        	Statement stmt = con.createStatement();
        	setException(false);
        	rset = stmt.executeQuery(sqlStr); 
              
        }catch (SQLException e) {
        	System.out.print("FEL tyyyp DRIVERMANAGER TYP "+ e);
        	setException(true);
        }
        return rset;  
	}
	
	public void setException(boolean caughtException) {
		exception = caughtException;
	}
	
	public boolean getException() {
		return exception;
	}
}
