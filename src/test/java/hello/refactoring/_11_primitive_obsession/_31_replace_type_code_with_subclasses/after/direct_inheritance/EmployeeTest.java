package hello.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.after.direct_inheritance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void employeeType() {
		assertEquals("engineer", Employee.createEmployee("hslee", "engineer").getType());
		assertEquals("manager", Employee.createEmployee("hslee", "manager").getType());
		assertThrows(IllegalArgumentException.class, () -> Employee.createEmployee("hslee", "wrong type"));
	}

}
