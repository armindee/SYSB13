package TestModel;

public class TestStudent {
	private String spnr;
	private String name;
	private String adress;
	private String telnr;
	
	public TestStudent (String spnr, String name, String adress, String telnr) {
		setSpnr(spnr);
		setName(name);
		setAdress(adress);
		setTelnr(telnr);
	}

	public void setSpnr(String spnr) {
		this.spnr = spnr;
	}
	
	public String getSpnr() {
		return spnr;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getAdress() {
		return adress;
	}

	public void setTelnr(String telnr) {
		this.telnr = telnr;
	}
	
	public String getTelnr() {
		return telnr;
	}
}
