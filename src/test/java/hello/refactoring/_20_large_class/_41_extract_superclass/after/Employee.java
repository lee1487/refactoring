package hello.refactoring._20_large_class._41_extract_superclass.after;

public class Employee extends Party {

	private Integer id;
	private double monthlyCost;

	public Employee(String name) {
		super(name);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public double monthlyCost() {
		return monthlyCost;
	}


}
