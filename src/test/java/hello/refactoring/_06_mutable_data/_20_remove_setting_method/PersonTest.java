package hello.refactoring._06_mutable_data._20_remove_setting_method;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void person() {
		Person person = new Person(10);
		person.setName("hslee");
		assertEquals(10, person.getId());
		assertEquals("hslee", person.getName());
		person.setName("keesun");
		assertEquals("keesun", person.getName());
	}

}
