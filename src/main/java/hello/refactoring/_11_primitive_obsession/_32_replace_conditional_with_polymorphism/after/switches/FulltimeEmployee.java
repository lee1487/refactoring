package hello.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.after.switches;

public class FulltimeEmployee extends Employee {

	@Override
	public int vacationHours() {
		return 120;
	}

	@Override
	public boolean canAccessTo(String project) {
		return true;
	}
}
