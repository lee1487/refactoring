package hello.refactoring._06_mutable_data._23_change_reference_to_value.after;


public class Person2 {

	private TelephoneNumber2 officeTelephoneNumber;

	public String officeAreaCode() {
		return this.officeTelephoneNumber.areaCode();
	}

	public void officeAreaCode(String areaCode) {
		this.officeTelephoneNumber = new TelephoneNumber2(areaCode, this.officeNumber());
	}

	public String officeNumber() {
		return this.officeTelephoneNumber.number();
	}

	public void officeNumber(String number) {
		this.officeTelephoneNumber = new TelephoneNumber2(this.officeAreaCode(),number);
	}
}
