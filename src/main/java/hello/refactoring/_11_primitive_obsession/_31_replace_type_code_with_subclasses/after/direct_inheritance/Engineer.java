package hello.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.after.direct_inheritance;

public class Engineer extends Employee{

	public Engineer(String name) {
		super(name);
	}
	
	@Override
	public String getType() {
		return "engineer";
	}

}
