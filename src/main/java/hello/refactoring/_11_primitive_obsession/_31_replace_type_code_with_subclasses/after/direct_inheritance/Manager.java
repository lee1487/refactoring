package hello.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.after.direct_inheritance;

public class Manager extends Employee{

	public Manager(String name) {
		super(name);
	}

	@Override
	public String getType() {
		return "manager";
	}
}
