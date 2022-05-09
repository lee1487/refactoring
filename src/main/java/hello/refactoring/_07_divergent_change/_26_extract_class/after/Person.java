package hello.refactoring._07_divergent_change._26_extract_class.after;

public class Person {

	private String name;
	private final TelephoneNumber telephoneNumber;

	public Person(String name, TelephoneNumber telephoneNumber) {
		this.name = name;
		this.telephoneNumber = telephoneNumber;
	}

	public String telephoneNumber() {
		return this.telephoneNumber.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TelephoneNumber getTelephoneNumber() {
		return telephoneNumber;
	}



}
