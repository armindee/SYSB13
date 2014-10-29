package TestController;

import TestDataAcessLayer.*;
import TestModel.*;

public class RegisterController {
	private TestStudent student;
	private TestCourse course;
	private TestUpdateDataAcessLayer updateDataAccessLayer;
	public String exceptionMessage;
	
	public RegisterController() {
		updateDataAccessLayer = new TestUpdateDataAcessLayer();
	}
	
	public void registerStudent(String spnr, String name, String adress, String telnr) {
		student = new TestStudent(spnr, name, adress, telnr);
		updateDataAccessLayer.registerStudent(student);
	}
	
	public void registerCourse(String ccode, String cname, String cadress, int points) {
		course = new TestCourse(ccode, cname, cadress, points);
		updateDataAccessLayer.registerCourse(course);
	}
	
	public void registerStudentToCourse(TestStudent student, TestCourse course) {
		updateDataAccessLayer.registerStudentToCourse(student, course);
	}
	
	public void registerStudentGrade(TestStudent student, TestCourse course, String grade) {
		updateDataAccessLayer.registerStudentGrade(student, course, grade);
		updateDataAccessLayer.deleteStudentFromCourse(course, student);
	}
	
	public boolean checkForException() {
		if(updateDataAccessLayer.getException()) {
			exceptionMessage = "Någonting gick fel, vänligen kontakta administratör";
			return true;
		}else {
			exceptionMessage = null;
			return false;
		}
	}

}
