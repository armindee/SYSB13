package TestController;

import TestDataAcessLayer.TestExecuteDataAcessLayer;
import TestDataAcessLayer.TestUpdateDataAcessLayer;
import TestModel.TestCourse;
import TestModel.TestStudent;

public class TestDeleteController {
	private TestStudent student;
	private TestCourse course;
	private TestUpdateDataAcessLayer updateDataAccessLayer;
	private TestExecuteDataAcessLayer searchDataAcessLayer;
	public String exceptionMessage;
	
	public TestDeleteController() {
		updateDataAccessLayer = new TestUpdateDataAcessLayer();
		searchDataAcessLayer = new TestExecuteDataAcessLayer();
	}
	
	public void deleteStudent(String spnr) {
		student = searchDataAcessLayer.getStudent(spnr);
		updateDataAccessLayer.deleteStudent(student);
	}
	
	public void deleteCourse(String ccode) {
		course = searchDataAcessLayer.getCourse(ccode);
		updateDataAccessLayer.deleteCourse(course);
	}
	
	public void deleteStudentFromCourse(String ccode, String spnr) {
		course = searchDataAcessLayer.getCourse(ccode);
		student = searchDataAcessLayer.getStudent(spnr);
		updateDataAccessLayer.deleteStudentFromCourse(course, student);
	}
	
	public void registerCourse(String ccode, String cname, String cadress, int points) {
		course = new TestCourse(ccode, cname, cadress, points);
		updateDataAccessLayer.registerCourse(course);
	}
	
	public void registerStudentToCourse(TestStudent student, TestCourse course) {
		updateDataAccessLayer.registerStudentToCourse(student, course);
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
