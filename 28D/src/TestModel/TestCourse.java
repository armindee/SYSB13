package TestModel;

public class TestCourse {
	private String ccode;
	private String cname;
	private String cadress;
	private int points;
	
	public TestCourse(String ccode, String cname, String cadress, int points) {
		setCcode(ccode);
		setCname(cname);
		setCadress(cadress);
		setPoints(points);
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	
	public String getCcode() {
		return ccode;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public String getCname() {
		return cname;
	}

	public void setCadress(String cadress) {
		this.cadress = cadress;
	}
	
	public String getCadress() {
		return cadress;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}

}
