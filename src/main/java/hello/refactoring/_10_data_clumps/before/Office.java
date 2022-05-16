package hello.refactoring._10_data_clumps.before;

public class Office {

	private String location;
	private String officeAreaCode;
	private String officeNumber;

	public Office(String location, String officeAreaCode, String officeNumber) {
		this.location = location;
		this.officeAreaCode = officeAreaCode;
		this.officeNumber = officeNumber;
	}

	public String officePhoneNumber() {
		return officeAreaCode + "-" + officeNumber;
	}

	public String getOfficeAreaCode() {
		return officeAreaCode;
	}

	public void setOfficeAreaCode(String officeAreaCode) {
		this.officeAreaCode = officeAreaCode;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}




}
