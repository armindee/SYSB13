package TestController;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import TestDataAcessLayer.*;
import TestModel.*;

public class TestSearchController {
	private TestStudent student;
	private TestCourse course;
	private String grade;
	ArrayList<TestStudent> gradeList;
	ArrayList<TestCourse> courseList;
	DefaultTableModel tableModel;
	private TestExecuteDataAcessLayer searchDataAccessLayer;
	public String exceptionMessage;
	
	public TestSearchController() {
		searchDataAccessLayer = new TestExecuteDataAcessLayer();
	}
	
	public TestStudent getStudent(String spnr) {
		student = searchDataAccessLayer.getStudent(spnr);
		return student;
	}
	
	public TestCourse getCourse(String ccode) {
		course = searchDataAccessLayer.getCourse(ccode);
		return course;
	}
	
	public String getGrade(String ccode, String spnr) {
		grade = searchDataAccessLayer.getGrade(ccode, spnr);
		return grade;
	}
	
	public DefaultTableModel getTabelModelForGrade(String ccode) {
		try {
			gradeList = searchDataAccessLayer.getGradeList(ccode);
			tableModel = new DefaultTableModel(
				new Object[][] {		
						
				},
				new String[] {
				"Student ID", "Name", "Address", "Phone"
				}
				
			);
			
			int numberOfCollumns = tableModel.getColumnCount();
			
			for(TestStudent grade : gradeList) {
				Object[] row = new Object[numberOfCollumns];
				row[0] = grade.getSpnr();
				row[1] = grade.getName();
				row[2] = grade.getAdress();
				row[3] = grade.getTelnr();
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			System.out.println("Fel typ " + e);
			e.printStackTrace();
			searchDataAccessLayer.setException(true);
		}
		return tableModel;
	}
	
	public DefaultTableModel getTableModelForRegisterd(String ccode) {
		try {
			gradeList = searchDataAccessLayer.getRegisterdList(ccode);
			tableModel = new DefaultTableModel(
				new Object[][] {		
						
				},
				new String[] {
				"Student ID", "Name", "Address", "Phone"
				}
				
			);
			
			int numberOfCollumns = tableModel.getColumnCount();
			
			for(TestStudent grade : gradeList) {
				Object[] row = new Object[numberOfCollumns];
				row[0] = grade.getSpnr();
				row[1] = grade.getName();
				row[2] = grade.getAdress();
				row[3] = grade.getTelnr();
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			System.out.println("Fel typ " + e);
			e.printStackTrace();
			searchDataAccessLayer.setException(true);
		}
		return tableModel;
	}
	
	public DefaultTableModel getTabelModelForStudentGrade(String spnr) {
		try {
			gradeList = searchDataAccessLayer.getStudentsGrades(spnr);
			tableModel = new DefaultTableModel(
				new Object[][] {		
						
				},
				new String[] {
				"Student ID", "Name", "Address", "Phone"
				}
				
			);
			
			int numberOfCollumns = tableModel.getColumnCount();
			
			for(TestStudent grade : gradeList) {
				Object[] row = new Object[numberOfCollumns];
				row[0] = grade.getSpnr();
				row[1] = grade.getName();
				row[2] = grade.getAdress();
				row[3] = grade.getTelnr();
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			System.out.println("Fel typ " + e);
			e.printStackTrace();
			searchDataAccessLayer.setException(true);
		}
		return tableModel;
	}
	
	public DefaultTableModel getTabelModelForStudentCourse(String spnr) {
		try {
			courseList = searchDataAccessLayer.getStudentRegisterdList(spnr);
			tableModel = new DefaultTableModel(
				new Object[][] {		
						
				},
				new String[] {
				"Student ID", "Name", "Address", "Phone"
				}
				
			);
			
			int numberOfCollumns = tableModel.getColumnCount();
			
			for(TestCourse course : courseList) {
				Object[] row = new Object[numberOfCollumns];
				row[0] = course.getCcode();
				row[1] = course.getCname();
				row[2] = course.getCadress();
				row[3] = course.getPoints();
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			System.out.println("Fel typ " + e);
			e.printStackTrace();
			searchDataAccessLayer.setException(true);
		}
		return tableModel;
	}
	
	public DefaultTableModel getTableModelForAllStudents() {
		try {
			gradeList = searchDataAccessLayer.getAllStudents();
			tableModel = new DefaultTableModel(
				new Object[][] {		
						
				},
				new String[] {
				"Student ID", "Name", "Address", "Phone"
				}
				
			);
			
			int numberOfCollumns = tableModel.getColumnCount();
			
			for(TestStudent student : gradeList) {
				Object[] row = new Object[numberOfCollumns];
				row[0] = student.getSpnr();
				row[1] = student.getName();
				row[2] = student.getAdress();
				row[3] = student.getTelnr();
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			System.out.println("Fel typ " + e);
			e.printStackTrace();
			searchDataAccessLayer.setException(true);
		}
		return tableModel;
	}
	
	public DefaultTableModel getTableModelForAllCourses() {
		try {
			courseList = searchDataAccessLayer.getAllCourses();
			tableModel = new DefaultTableModel(
				new Object[][] {		
						
				},
				new String[] {
				"Course ID", "Name", "Address", "Points"
				}
				
			);
			
			int numberOfCollumns = tableModel.getColumnCount();
			
			for(TestCourse course : courseList) {
				Object[] row = new Object[numberOfCollumns];
				row[0] = course.getCcode();
				row[1] = course.getCname();
				row[2] = course.getCadress();
				row[3] = course.getPoints();
				tableModel.addRow(row);
			}
			
		} catch (SQLException e) {
			System.out.println("Fel typ " + e);
			e.printStackTrace();
			searchDataAccessLayer.setException(true);
		}
		return tableModel;
	}
	
	public boolean checkForException() {
		System.out.println(searchDataAccessLayer.getException());
		if(searchDataAccessLayer.getException()) {
			exceptionMessage = "Någonting gick fel, vänligen kontakta administratör";
			return true;
		}else {
			exceptionMessage = null;
			return false;
		}
	}
}
