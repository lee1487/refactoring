package hello.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.after.indirect_inheritance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void capitalizedType() {
		assertEquals("Manager", new FullTimeEmployee("hslee", "manager").capitalizedType());
		assertEquals("Engineer", new PartTimeEmployee("hslee", "engineer").capitalizedType());
		assertThrows(IllegalArgumentException.class, () -> new Employee("hslee", "wrong type"));
	}

}
