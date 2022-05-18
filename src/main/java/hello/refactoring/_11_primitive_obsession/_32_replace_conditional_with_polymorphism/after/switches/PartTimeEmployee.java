package hello.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.after.switches;

import java.util.List;

public class PartTimeEmployee extends Employee {

	public PartTimeEmployee(List<String> availableProjects) {
		super(availableProjects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int vacationHours() {
		return 80;
	}

}
