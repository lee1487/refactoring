package hello.refactoring._10_data_clumps.after;

public class Office {

	private String location;
	private TelephoneNumber officePhoneNumber;

	public Office(String location, TelephoneNumber officePhoneNumber) {
		this.location = location;
		this.officePhoneNumber = officePhoneNumber;
	}

	public String officePhoneNumber() {
		return this.officePhoneNumber.toString();
	}

	public String getOfficeAreaCode() {
		return this.officePhoneNumber.getAreaCode();
	}

	public void setOfficeAreaCode(String officeAreaCode) {
		this.officePhoneNumber.setAreaCode(officeAreaCode);
	}

	public String getOfficeNumber() {
		return this.officePhoneNumber.getNumber();
	}

	public void setOfficeNumber(String officeNumber) {
		this.officePhoneNumber.setNumber(officeNumber);
	}




}
